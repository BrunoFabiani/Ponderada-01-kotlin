# ponderada-base-m10-01
Atividade Ponderada 1

Como a atividade foi feita:

Encontrei o bug testando o aplicativo e notando que o dado não roda até 6 e roda 0, o que não é o comportamento certo de um dado D6. Concertei o erro adicionando 1 para o resultado do D6.
Depois disso peguei o formato que o app atendia o D6, com o OnClick mudando o estado, e expandi para incluir D10, D20 e D100 também junto com adicionando a opção do usuário clicar nele.

Seria muitas imagens colocar 100 dados diferentes então montei uma versão menor dela, mostrando so os dados d-10, d-20 e d-100 respectivamente quando o valor rolado ser maior que 6.

Nomei todas as imagens correspondentamente e fiz com que a variavel que eu colocaria no Image seria "dice_" + numeroImagem o que puxava a imagem correta para isso. “Para isso, utilizei context.resources.getIdentifier(), que permite buscar dinamicamente uma imagem pelo nome dentro dos recursos do aplicativo.”
