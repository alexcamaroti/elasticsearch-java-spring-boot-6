##Mapping

```

PUT /produtos_autocomplete_dev
{
  "settings": {
    "number_of_replicas": 0,
    "number_of_shards": 3,
    "analysis" : {
    "filter" : {
      "filtro_autocomplete" : {
        "type" : "edge_ngram",
        "min_gram" : 2,
        "max_gram" : 20
      }
    },
    "analyzer": {
     "autocomplete" : {
       "type" : "custom",
       "tokenizer" : "standard",
       "filter" : [
         "lowercase",
         "filtro_autocomplete"
         ]
     } 
    }
  }
  },
  "mappings": {
    "v1" : {
      "_all" : {
        "type" : "text",
        "analyzer" : "portuguese"
      },
      "properties" : {
        "name" : {
          "type" : "text",
          "analyzer" : "portuguese",
          "fields" : {
            "original" : {
              "type" : "keyword"
            },
            "autocomplete" : {
              "type" : "text",
              "analyzer" : "autocomplete"
            }
          }
        },
          "category" : {
            "type" : "text",
            "analyzer" : "portuguese",
            "fields" : {
              "original" : {
                "type" : "keyword"
              }
            }
          },
          "subcategory" : {
            "type" : "text",
            "analyzer" : "portuguese",
            "fields" : {
              "original" : {
                "type" : "keyword"
              }
            }
          },
          "tags" : {
            "type" : "text",
            "analyzer" : "portuguese",
            "index" : "true",
            "fields" : {
              "original" : {
                "type" : "keyword"
              }
            }
          },
          "provider" : {
            "type" : "text",
            "fields" : {
              "original" : {
                "type" : "keyword"
              }
            }
          },
          "price" : {
            "type" : "float"
          }
      }
  }
}
}

```

##Populating

```

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Big Data rápido e fácil",
	  "category": "Livros",
	  "subcategory": "Tecnologia",
	  "tags": ["impresso", "digital", "larga escala", "computação"],
	  "provider": "Casa do Código",
	  "price": 29.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Guia rápido e fácil para big data",
	  "category": "Livros",
	  "subcategory": "Tecnologia",
	  "tags": ["impresso", "digital", "larga escala", "computação"],
	  "provider": "Casa do Código",
	  "price": 219.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Big Data: Técnicas e tecnologias para extração de valor dos dados",
	  "category": "Livros",
	  "subcategory": "Tecnologia",
	  "tags": ["impresso", "digital", "larga escala", "computação"],
	  "provider": "Casa do Código",
	  "price": 49.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Think Big: Guia para sua micro empresa",
	  "category": "Livros",
	  "subcategory": "Tecnologia",
	  "tags": ["impresso", "digital", "larga escala", "computação"],
	  "provider": "Casa do Código",
	  "price": 49.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "A história do futebol brasileiro",
	  "category": "Livros",
	  "subcategory": "Esportes",
	  "tags": ["impresso", "digital", "esportes", "futebol"],
	  "provider": "Casa do Código",
	  "price": 59.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "A história do Brasil",
	  "category": "Livros",
	  "subcategory": "Escolar",
	  "tags": ["impresso", "digital", "escola", "história"],
	  "provider": "Casa do Código",
	  "price": 34.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Contos dos melhores escritores do Brasil",
	  "category": "Livros",
	  "subcategory": "Literatura",
	  "tags": ["impresso", "literatura", "nacional"],
	  "provider": "Casa do Código",
	  "price": 57.25
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Bola de futsal",
	  "category": "Esportes",
	  "subcategory": "Futebol",
	  "tags": ["futebol", "amador", "quadra"],
	  "provider": "Irmãos Silveira Esportes",
	  "price": 29.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Camiseta Seleção Brasileira",
	  "category": "Roupas",
	  "subcategory": "Esportes",
	  "tags": ["futebol", "amador", "seleção", "amarelinha"],
	  "provider": "Irmãos Silveira Esportes",
	  "price": 129.90
	}

	POST /produtos_autocomplete_dev/v1/
	{
	  "name": "Chuteira de Futebol",
	  "category": "Calçados",
	  "subcategory": "Esportes",
	  "tags": ["futebol", "amador", "campo", "amarelinha"],
	  "provider": "Irmãos Silveira Esportes",
	  "price": 129.90
	}

```

