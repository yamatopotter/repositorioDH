# ==========================================================================

# Objetivo: declaramos todas as variáveis que vamos usar

# Autor : DH

# Date: 07.30.21

# Version: 1.0

# =========================================================================

variable "aws_region_id" {
description = "a região"

type = string
default = "us-east-1"

}

variable "main_vpc_cidr" {
    description = "Nosso Grupo de Segurança"
    type = string
    default = "10.0.0.0/24"
}

variable "public_subnets" {
    description = "sub-rede com acesso à internet"
    type = string
    default = "10.0.0.128/26"
}

variable "private_subnets" {
    description = "sub-rede sem acesso à Internet"
    type = string
    default = "10.0.0.192/26"
}

# =======================================================================