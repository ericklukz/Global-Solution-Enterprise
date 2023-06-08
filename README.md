# GLOBAL-SOLUTION-BUSINESS

# apresentação do projeto

https://www.youtube.com/watch?v=CQifoCnvLig

# Endpoints


## Usuario
- [Login](#login)
- [Listar Todos usuários](#listar_usuários)
- [Buscar usuário](#buscar_usuário)
- [Cadastrar usuário](#cadastrar_usuário)
- [Atualizar usuário](#atualizar_usuário)
- [Deletar usuário](#deletar_telefone)

## Telefone
- [Listar telefones por ID de usuário](#listar_telefone_por_id)
- [Cadastrar telefone](#cadastar_telefone_usuario)
- [Atualizar telefone](#atualizar_usuário)
- [Deletar telefone](#deletar_telefone)

## Terreno
- [Listar terrenos por ID de usuário](#listar_terrenos_por_id)
- [Cadastrar terreno](#cadastrar_terreno)
- [Atualiza terreno](#atualizar_terreno)
- [Deleta terreno](#deletar_terreno)

## Hortaliça
- [Listar hortaliças](#listar_hortaliças)
- [Buscar Hortaliça](#buscar_hortaliça)
- [Buscar MesInicio]()
- [Buscar MesFim]()
- [Buscar Nome da hortalica]()
- [Cadastrar hortaliças](#cadastrar_hortalica)
- [Atualizar hortaliças](#atualizar_hortaliças)
- [deletar hortaliças](#deletar_hortaliça)

## Tipo das Hortaliças
- [Listar tipos de hortaliças](#listar-tipos_de_hortaliças)
- [Buscar tipo de hortaliça](#buscar_tipo_hortaliça)
- [Cadastrar tipo hortaliças](#cadastrar_tipo_hortaliças)
- [Atualizar um tipo de hortaliças](#atualizar_tipo_hortaliças)
- [deletar tipo de hortaliças](#deletar_tipo_hortalica)

---
padrão

GET 
- endpoint
- exemplo corpo de resposta
- http responses

POST
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

PUT
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

DELETE
- endpoint 
- exemplo de request 
- não há corpo de resposta 
- http responses
---

## Usuário

### Login

`POST` /globalSolutio/api/usuarios/login

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|    Username  |String|     Sim     | Campo para que insira um nome para usar no aplicativo
|     Senha    |String|     Sim     | Senha do usuário para acesso 

**Exemplo Corpo do request**
```JSON
{
    "username":"marimari",
    "senha":"hello"
}
```

**Exemplo corpo de reposta**
```JSON
{
    "token": <token gerado>,
    "type": "JWT",
    "prefix": "Bearer"
}
```
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Listar_Usuários

`GET` /globalSolutio/api/usuarios

**Exemplo Corpo de resposta**

```JSON
[
    {
        "id": 1,
        "nome": "nieke",
        "username": "nike",
        "senha": "nike"
    },
    {
        "id": 2,
        "nome": "nieke",
        "username": "nike",
        "senha": "nike"
    }
]
```
**HTTP responses para GET**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Buscar_Usuário

`GET` /globalSolutio/api/usuarios/{id}

**Exemplo Corpo de resposta**
```JSON
{
    "id": 1,
    "nome": "nieke",
    "username": "nike",
    "senha": "nike"
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_Usuário

`POST` /globalSolutio/api/usuarios

**Atributos do request**
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     | Campo para preenchimento de nome de usuario
|    Username  |String|     Sim     | Campo para que insira um nome para usar no aplicativo
|     Senha    |String|     Sim     | O usuario deve criar uma senha  para uso do aplicativo

**Exemplo Corpo do request**
```JSON
{
    "nome": "Jose Augusto da Silva",
    "username": "JoseGuto",
    "senha": "222222"
}

```

**Exemplo corpo de resposta**
```JSON
{
    "id": 3,
    "nome": "CJose Augusto da Silvaarlos",
    "username": "JoseGuto",
    "senha": "222222@",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
        {
            "authority": "ROLE_USUARIO"
        }
    ],
    "password": "222222@",
    "accountNonLocked": true
}
```

**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Usuário

`PUT` /globalSolutio/api/usuarios/{id}

**Atributos do request**
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     | Campo para preenchimento de nome de usuario
|    Username  |String|     Sim     | Campo para que insira um nome para usar no aplicativo
|     Senha    |String|     Sim     | O usuario deve criar uma senha  para uso do aplicativo

**Exemplo Corpo do request**

```JSON
{
    "nome":"java",
    "username":"java",
    "senha": "java"
}
```

**Exemplo Corpo do response**
```JSON
{
    "id": 1,
    "nome": "java",
    "username": "java",
    "senha": "java"
}
```

**Respostas que podem aparecer no `PUT` :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Usuário

`Delete` /globalSolutio/api/usuarios/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no DELETE :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Telefone

### Listar_Telefone_por_ID
`GET` globalSolution/api/telefones/?idUsuario=1

```JSON
{
    "id": 1,
    "telefone": "956783112",
    "ddd": "011",
    "ddi": "+55",
    "usuario":{
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    }
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastar_Telefone_Usuario
`POST` globalSolutio/api/telefones

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| telefone | String | Sim | Campo que contém o telefone do usuário até 9 digitos 
| ddd | String | Sim | Contém o código de endereçamento urbano brasileiro
| ddi | String | Sim | Contém o codigo de discagem direta internacional
| usuario | Object | Sim | Contém um objeto referente a um usuário contendo ID, nome e username

**Exemplo do Corpo do Request**
```JSON
{
    "telefone":"123456",
    "ddd":"011",
    "ddi":"55555",
    "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    }
}
```
**Exemplo do Corpo do Response**
```JSON
{
    "id": 1,
    "telefone": "111111111",
    "ddd": "123",
    "ddi": "55555",
    "usuario": {
        "id": 1,
        "nome": "Carlos",
        "username": "carlitos",
        "senha": "alo"
        }
},
```
**Respostas que podem aparecer no POST :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Telefone

`PUT` globalSolutio/api/telefones/{id_usuario}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| telefone | String | Sim | Campo que contém o telefone do usuário até 9 digitos 
| ddd | String | Sim | Contém o código de endereçamento urbano brasileiro
| ddi | String | Sim | Contém o codigo de discagem direta internacional
| usuario | Object | Sim | Contém um objeto referente a um usuário contendo ID, nome e username

**Exemplo do Corpo do Request**
```JSON
{
    "telefone":"123456",
    "ddd":"011",
    "ddi":"55555",
}
```
**Exemplo do Corpo do Response**
```JSON
{
    "id": 1,
    "telefone": "111111111",
    "ddd": "123",
    "ddi": "55555",
    "usuario": {
        "id": 1,
        "nome": "Carlos",
        "username": "carlitos",
        "senha": "alo"
        }
},
```
**Respostas que podem aparecer no PUT :**
| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_Telefone

`Delete` /globalSolutio/api/telefones/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Terreno

### Listar_terrenos_por_ID


`GET` globalSolution/api/terrenos/?idUsuario=1

**Exemplo do Corpo do Request `GET`**

```JSON
            {
        
			"id": 1,
			"tamanho": "125m",
			"descricao": "grande da roça",
			"logradouro": "Rua n/a",
			"numeroLogradouro": "1225",
			"regiao": "ZS",
			"usuario": {
				"id": 1,
				"nome": "Maria",
				"username": "carlitos",
				"senha": "alo"
			},
			"hortalica": {
				"id": 1,
				"nome": "cenoura",
				"mesInicio": "fevereiro",
				"mesFim": "agosto",
				"tipoHortalica": {
					"id": 3,
					"nome": "c",
					"familiaBotanica": "alou"
				}
			}
        }
```

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_Terreno 
`POST` globalSolution/api/terrenos

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| tamanho | String | Sim | Contém o tamanho do terreno sendo cadastrado
| descricao | String | Sim | Contém a descrição e observações sobre o terreno
| logradouro | String | Sim | Contém o endereço do terreno cadastrado
| numeroLogradouro | String | Sim | Contém o numero do logradouro do terreno
| regiao | String | Sim | Contém a região do terreno cadastrado contendo apenas 2 caracteres
| usuario | Object | Sim | Contém o objeto que referencia o usuário que está cadastrando o terreno contendo ID, nome e username
| hortalica | obejct | Sim | Contém o objeto que referencia a hortliça que está sendo cultivada no terreno contendo ID, nome, mesInicio, mesFim e tipoHortalica

**Exemplo do Corpo do Request `POST`**

```JSON
{
    "tamanho": "125m",
    "descricao": "grande da roça",
    "logradouro": "Rua n/a",
    "numeroLogradouro": "1225",
    "regiao": "ZS",
        "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    },
    "hortalica": {
        "id": 1,
        "nome": "cenoura",
        "mesInicio": "fevereiro",
        "mesFim": "agosto",
        "tipoHortalica": {
            "id": 3,
            "nome": "c",
            "familiaBotanica": "alou"
        }
    }
}
```

**Exemplo do Corpo do Response**

```JSON
{
    "id": "1",
    "tamanho": "125m",
    "descricao": "grande da roça",
    "logradouro": "Rua n/a",
    "numeroLogradouro": "1225",
    "regiao": "ZS",
        "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    },
    "hortalica": {
        "id": 1,
        "nome": "cenoura",
        "mesInicio": "fevereiro",
        "mesFim": "agosto",
        "tipoHortalica": {
            "id": 3,
            "nome": "c",
            "familiaBotanica": "alou"
        }
    }
}
```

**Respostas que podem aparecer no `POST`**

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Terreno
`PUT` globalSolution/api/terrenos/{id_usuario}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| tamanho | String | Sim | Contém o tamanho do terreno sendo cadastrado
| descricao | String | Sim | Contém a descrição e observações sobre o terreno
| logradouro | String | Sim | Contém o endereço do terreno cadastrado
| numeroLogradouro | String | Sim | Contém o numero do logradouro do terreno
| regiao | String | Sim | Contém a região do terreno cadastrado contendo apenas 2 caracteres
| usuario | Object | Sim | Contém o objeto que referencia o usuário que está cadastrando o terreno contendo ID, nome e username
| hortalica | obejct | Sim | Contém o objeto que referencia a hortliça que está sendo cultivada no terreno contendo ID, nome, mesInicio, mesFim e tipoHortalica

**Exemplo do Corpo do Response `PUT`**

```JSON
{
    "id": "1",
    "tamanho": "125m",
    "descricao": "grande da roça",
    "logradouro": "Rua n/a",
    "numeroLogradouro": "1225",
    "regiao": "ZS",
        "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    },
    "hortalica": {
        "id": 1,
        "nome": "cenoura",
        "mesInicio": "fevereiro",
        "mesFim": "agosto",
        "tipoHortalica": {
            "id": 3,
            "nome": "c",
            "familiaBotanica": "alou"
        }
    }
}
```

**Exemplo do Corpo do Response `PUT`**

```JSON
		{
			"id": 1,
			"tamanho": "180m",
			"descricao": "grande da vila",
			"logradouro": "Rua n/a",
			"numeroLogradouro": "1900",
			"regiao": "ZN",
			"usuario": {
				"id": 1,
				"nome": "Maria",
				"username": "carlitos",
				"senha": "alo"
			},
			"hortalica": {
				"id": 1,
				"nome": "cenoura",
				"mesInicio": "fevereiro",
				"mesFim": "agosto",
				"tipoHortalica": {
					"id": 3,
					"nome": "c",
					"familiaBotanica": "alou"
				}
			}
        }
```

**Respostas que podem aparecer no `PUT` :**

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não 
---
### Deletar_Terreno

`Delete` /globalSolutio/api/terrenos/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Hortalica

### Busca_Mes_Fim
`GET` globalSolution/api/hortalicas/fim/?mesFim=setembro

**Exemplo Corpo de resposta**
```JSON
{
    "id": 1,
    "nome": "cenoura",
    "mesInicio": "fevereiro",
    "mesFim": "setembro",
    "tipoHortalica": {
        "id": 3,
        "nome": "c",
        "familiaBotanica": "alou"
    }
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Busca_Mes_Inicio

`GET` globalSolution/api/hortalicas/inicio?mesInicio=fevereiro

**Exemplo Corpo de resposta**
```JSON
{
    "id": 1,
    "nome": "cenoura",
    "mesInicio": "fevereiro",
    "mesFim": "agosto",
    "tipoHortalica": {
        "id": 3,
        "nome": "c",
        "familiaBotanica": "alou"
    }
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Listar_Hortaliças

`GET` /globalSolutio/api/hortalicas/?nome="cenoura"

parâmetro "nome" opcional

**Exemplo Corpo de resposta**

```JSON
    {
		"id": 1,
		"nome": "cenoura",
		"mesInicio": "fevereiro",
		"mesFim": "agosto",
		"tipoHortalica": {
			"id": 3,
			"nome": "A",
			"familiaBotanica": "Liliaceas"
			}
	},
		{
		"id": 2,
		"nome": "repolho",
		"mesInicio": "maio",
		"mesFim": "setembro",
		"tipoHortalica": {
			"id": 1,
			"nome": "B",
			"familiaBotanica": "Solenaceas"
			}

        }
        
```

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|

---
### Buscar_Hortaliça

`GET` /globalSolutio/api/hortalicas/{id}

**Exemplo Corpo de resposta**
```JSON
{
		"id": 1,
		"nome": "cenoura",
		"mesInicio": "fevereiro",
		"mesFim": "agosto",
		"tipoHortalica": {
			"id": 3,
			"nome": "A",
			"familiaBotanica": "Liliaceas"
		}
}

```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_Hortalica

`POST` /globalSolutio/api/hortalicas/

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| nome | String | sim | Nome da hortalça que está sendo cadastrada
| mesInicio | String | sim | O mês de inicio do período fértil da hortaliça que está sendo cadastrada
| mesFim | String | sim | O mês do fim do período fértil da hortaliça que está sendo cadastrada
| tipoHortalica | Obejct | sim | Objeto que se refere ao tipo da hortaliça que esta sendo cadastrada contendo ID, nome e familia botanica

**Exemplo Corpo de request**
```JSON
{
		"id": 1,
		"nome": "Beterraba",
		"mesInicio": "Abril",
		"mesFim": "Agosto",
		"tipoHortalica": {
			"id": 3,
			"nome": "A",
			"familiaBotanica": "Liliaceas"
		}
}
```

**Exemplo Corpo de resposta**
```JSON
{
		"id": 1,
		"nome": "Beterraba",
		"mesInicio": "Abril",
		"mesFim": "Agosto",
		"tipoHortalica": {
			"id": 3,
			"nome": "A",
			"familiaBotanica": "Liliaceas"
		}
}
```
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Hortaliças

`PUT` /globalSolutio/api/hortalicas/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|    Nome      |String|     Sim     | Nome da hortalça que está sendo cadastrada
|   mesInicio  |String|     Sim     | O mês de inicio do período fértil da hortaliça que está sendo cadastrada
|   mesFim     |String|     Sim     | Objeto que se refere ao tipo da hortaliça que esta sendo cadastrada contendo ID, nome e familia botanica

**Exemplo Corpo de request**

```JSON
{
		"id": 1,
		"nome": "Beterraba",
		"mesInicio": "Abril",
		"mesFim": "Agosto",
		"tipoHortalica": {
			"id": 3,
			"nome": "A",
			"familiaBotanica": "Liliaceas"
		}
}
```

**Exemplo Corpo de resposta**
```JSON
{
		"id": 1,
		"nome": "Beterraba",
		"mesInicio": "Abril",
		"mesFim": "Agosto",
		"tipoHortalica": {
			"id": 3,
			"nome": "A",
			"familiaBotanica": "Liliaceas"
		}
}
```

**HTTP responses para `PUT`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Hortaliça

`Delete` /globalSolutio/api/hortalicas/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---


## Tipo das Hortaliças

### Listar tipos_de_Hortaliças

`GET` /globalSolutio/api/tipohortalicas/ 

**Exemplo Corpo de resposta**

```JSON
    {
	"id": 3,
	"nome": "A",
	"familiaBotanica": "Liliaceas"
		},
	{
	"id": 1,
	"nome": "B",
	"familiaBotanica": "Solenaceas"
		},
	{
	"id": 2,
	"nome": "S",
	"familiaBotanica": "Umbeliferas"
		}
```

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|

---
### Buscar_Tipo_Hortaliça

`GET` /globalSolutio/api/tipohortalicas

**Exemplo Corpo de resposta**
```JSON
{
    "id": 3,
    "nome": "A",
    "familiaBotanica": "Liliaceas"
},
```

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_tipo_Hortaliças

`POST` /globalSolutio/api/hortalicas/

|    Campo     |  Tipo  | Obrigatorio | Descrição
|--------------|--------|:-----------:|----------|
|     Nome     | String |     sim     | Nome da hortalça que está sendo cadastrada
| tipo Botanica| String |     sim     | Campo para verificar a familia e classe que o tipo da hortaliça pertence

**Exemplo Corpo de request**

```JSON
{
	"nome": "A",
	"familiaBotanica": "Liliaceas"
}
```
**Exemplo Corpo de response**

```JSON
{
	"nome": "A",
	"familiaBotanica": "Liliaceas"
}
```

**HTTP responses para `POST`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Tipo_Hortaliças


`PUT` /globalSolutio/api/hortalicas/{id}

|    Campo     |  Tipo  | Obrigatorio | Descrição
|--------------|--------|:-----------:|----------|
|     Nome     | String |     sim     | Nome da hortalça que está sendo cadastrada
| tipo Botanica| String |     sim     | Campo para verificar a familia e classe que o tipo da hortaliça pertence

**Exemplo Corpo de request**

```JSON
{
	"nome": "B",
	"familiaBotanica": "Liliaceas"
}
```
**Exemplo Corpo de response**

```JSON
{
	"nome": "A",
	"familiaBotanica": "Umbeliferas"
}
```

**HTTP responses para `PUT`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Tipo_Hortalica

`Delete` /globalSolutio/api/tipohortalicas/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---











---



PERGUNTAS
- equalsandhashcode (equals do object)
- JsonProperty (JSON -> objeto | Objeto -> JSON)
- paginação     public Page<Despesa> index(@RequestParam(required = false) String descricao "busca" , @PageableDefault(size = 5) Pageable pageable)
- busca
- ordenação


[
    {
        "id": 1,
        "telefone": "111111111",
        "ddd": "123",
        "ddi": "55555",
        "usuario": {
            "id": 1,
            "nome": "Carlos",
            "username": "carlitos",
            "senha": "alo"
        }
    },
    {
        "id": 2,
        "telefone": "222222",
        "ddd": "13",
        "ddi": "784",
        "usuario": {
            "id": 1,
            "nome": "Carlos",
            "username": "carlitos",
            "senha": "alo"
        }
    }
]
