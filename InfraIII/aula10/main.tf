# Objetivo: Criar a infraestrutura da AWS
# Autor: DH
# Data: 07.30. 21
# Versão: 1.0
# ============================================ ==== =======================
# ============================== === ============================================
# Nós criamos nossoVPC
resource "aws_vpc" "Principal" {
    # usamos o bloco "recurso", o "elemento provedor" e um "rótulo"
    cidr_block = var.main_vpc_cidr # nós passamos o bloco CIDR que eu quero usar como uma variável
    instance_tenancy = "default"
    tags = {
        Name = "My_VPC_aluno6pt45"
    }
}
# ============================================== ============================
# Criamos um Internet Gateway "E" o associamos ao PC que acaba de ser criado
resource "aws_internet_gateway" "IGW" { # Gateway de Internet
    vpc_id = aws_vpc.Principal.id # saberemos o vpc_id apenas quando o VPC for criado
    tags = {
        Name = "IGW"
    }
}

# ============================================================================
# Nós criamos a sub-rede pública
resource "aws_subnet" "public_subnets" { # nós criamos as sub-redes públicas
    vpc_id = aws_vpc.Principal.id
    cidr_block = var.public_subnets # Bloco CIDR para minhas sub-redes públicas
    tags = {
        Name = "Sub-rede pública"
    }
}
# =======================================================================
# Nós criamos nossa sub-redes privada
resource "aws_subnet" "private_subnets" {
    vpc_id = aws_vpc.Principal.id
    cidr_block = var.private_subnets # Bloco CIDR para minhas sub-redes privadas
    tags = {
        Name = "Sub-rede privada"
    }
}
# ========================================================================roteamento
# Tabela depara sub-rede pública

resource "aws_route_table" "Public_RT" { # Criamos nossa Tabela de Rotas para a sub-rede pública
    vpc_id = aws_vpc.Principal.id
    
    route{
        cidr_block = "0.0.0.0/0" # Declaramos que o tráfego da sub-rede pública chega à Internet a partir do gateway da Internet
        gateway_id = aws_internet_gateway.IGW.id
    }
    tags = {
        Name = "Public Routing Table"
    }
}
# =======================================================================roteamento
# Tabela depara sub-rede privada
resource "aws_route_table" "Private_RT" { # Criando RT para sub-rede privada
    vpc_id = aws_vpc.Principal.id
    route {
        cidr_block = "0.0.0.0/0" # Tráfego proveniente da sub-rede privada alcançando a Internet via Gateway NAT
        nat_gateway_id = aws_nat_gateway.NAT_GW.id
    }
    tags = {
        Name = "Tabela de roteamento privado"
    }
}
# =======================================================================rota
# Associação de tabela de sub-rede pública
resource "aws_route_table_association" "Public_RT_Association" {
    subnet_id = aws_subnet.public_subnets.id
    route_table_id = aws_route_table.Public_RT.id
}
# ===================================================================
# Associação de tabela de roteamento com sub-rede privada
resource "aws_route_table_association" "Private_RT_Association" {
    subnet_id = aws_subnet.private_subnets.id
    route_table_id = aws_route_table.Private_RT.id
}
resource "aws_eip" "NAT_EIP" {
    vpc = true
    tags = {
        Name = "NAT com elastic IP "
    }
}
# ======================================= == =========================
# Criação do NAT gateway usando subnet_id e allocation_id
resource "aws_nat_gateway" "NAT_GW" {
    allocation_id = aws_eip.NAT_EIP.id
    subnet_id = aws_subnet.public_subnets.id
    tags = {
        Name = "Gateway NAT alocado para sub-rede pública"
    }
}