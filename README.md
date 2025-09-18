# Repositório do execício de RMI - Prática de RMI em Java - Aula Assíncrona dia 12/09/2025

1. Experiência com RMI:
   - Como foi sua experiência ao implementar e testar os exercícios?
      - R: Foi muito boa, como vimos bastante a implemtação do RMI e testar levou mais um tempinho
   - O que você aprendeu sobre RMI ao longo desta prática?
      - R: Aprendi sobre como eu preciso ter as classes nos dois lados e que a serialização seja exata, e por isso existe as bibliotecas contendo todas as classes para facilitar o desenvolvimento.

2. Dificuldades Enfrentadas:
   - Quais foram os maiores desafios ou dificuldades durante a
   implementação?
      - R: Acho que somente verificar o concorrência da lista de mensagens, apesar de já conhecer o synchronized.
   - Como você resolveu esses problemas?
      - R: Pesquisei sobre o syncronized, e verifiquei onde poderia usar para lockar a lista, e preferi colocar na funções, porque assim ele usa a classe para lockar, e assim fazer somente uma ação por vez da classe.

3. Vantagens e Desvantagens:
   - Compare o uso de RMI com outras soluções que você já utilizou (por exemplo: sockets, CORBA ou Web Services)?
      - R: Ainda não usei essas soluções, mas entendo que o RMI é somente com Java, não possui uma interoperabilidade como em Corba por exemplo.

4. Aplicabilidade:
   - Em quais cenários você acredita que o RMI é mais útil?
      - R: Acredito que em cenários onde a equipe só trabalhe com Java, e que precisem dedicar uma máquina para um processamento específico, e então assim chamar os métodos dessa máquina remotamente. Ou cénarios onde exista um sistema Java legado.
   - Há cenários em que seria preferível usar outra tecnologia? Por quê?
      - R: Acho que em cenários que o frontend do cliente é em Javascript, como o RMI precisa que ambos os lados precisem ser trabalhados em Java, isso acaba com a flexibidade de soluções.
