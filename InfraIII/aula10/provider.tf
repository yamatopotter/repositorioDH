# ======================================================================= ====

# Objetivo: declaramos qual provedor de nuvem queremos usar

# Autor: DH

# Data: 30.07.21

# Versão: 1.0

# ======================================================================

# ========================================================================

# Declaramos o provedor de nuvem com o qual queremos trabalhar com o
terraform {

# Dizemos que queremos:
# a. a versão do binário de terraform maior ou igual a 0,12

required_version = ">=0.12"
    required_providers {

        aws = {
        # Nós especificamos de onde queremos fazer o download do binário:

        source = "hashicorp/aws"
        # Dizemos que só permitirá: ma
        # b. o provedor binário versão 3.20.0 (com algumas restrições)
        version = "~> 3.20.0"
        }

    }
}

# =======================================================================

# =======================================================================

# Declaramos a região onde desejamos para aumentar nossa infra

provider "aws" {
shared_credentials_file = "~/.aws/credentials"

region = "sa-east-1"
}

# ==========================================================================