[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10156166)

# Gestão de Estoque

Modernização da gestão de estoque de uma mercearia.

## Nota base do grupo: 7,85

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários
	- Ficou desorganizado a disposição dos elementos de trecho de código, principalmente referente aos que estão disponíveis em src/


### Diagrama + aderência das classes ao diagrama: 0,75/2 pontos 
	- No repositório existe apenas uma versão do diagrama e está com inconsistências. Nome da classe Veículo, não representar o atributo taxas como final, não possuir a outra classe, ...



### Requisitos corretamente implementados: 4,5/6 pontos 
	- produto (preço, estoque) - 1,5 / 2
	Não entendi muito bem o setMargemLucro(), com operações adicionais sendo realizadas
	Definiram valores hard code para nivel de estoque e margem de lucro

	- estoque (valor, abaixo do estoque) - 1,25 / 2
	valorTotaldoEstoque() - incompleto
	venderProduto() - definiu quantidade mínimo hard code
	Não realiza verificações a respeito de introduzir elementos de forma inconsistente

	- sistema (vender, comprar, consultas) 1,75 - /2
	A opção de Adicionar (2) no texto fala que é para informar ID do produto, porém se trata do preço de custo

	1 - Buscar produto - Ok
	2 - Adicionar produto - Ok
	3 - Quantidade de produtos em estoque - Ok
	4 - Ver estoque - Ok
	5 - Valor total do estoque - Erro
	6 - Vender produto - Permite vender quantidade superior a que possui. Ex: possue 5 em estoque e permite vender 50
	7 - Comprar produto/repor estoque - Ok
	8 - Produtos com estoque abaixo do minimo - Ok
	9 - Balanço da empresa - Erro
	0 - Sair do programa


### Documentação de código: 0,1 pontos 
	Documentação praticamente inexistente
	
### Testes (quantidade e qualidade): 2,5/4 pontos 
	Não documentaram o plano de testes
	Acredito que a suite de testes ficaram interessantes, porém não conseguiram implementar algumas lógicas, resultando assim na falha dos mesmos, como o caso testSetMargemLucro(), testSetDescricaoInvalida() ...
	Não recomendo o uso de mais de 1 assert por @Test, pois as vezes pode dificultar encontrar o motivo do erro
	- produto: 1,5/2 pontos
	
	- estoque: 1/2 pontos
	Alguns testes foram construídos de forra errada

	Apenas 3 casos de teste


## Alunos integrantes da equipe

- Pedro Luis Gonçalves
- Kaio Henrique Silvera
- Yghor Ribas Gomes
- Hitalo Silveira Porto
- Vítor Lion Guimarães Rodrigues

## Professores responsáveis

- Cleiton Silva Tavares
- João Caram
