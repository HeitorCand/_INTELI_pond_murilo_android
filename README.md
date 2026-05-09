
### 🎲 Atualização: Novos Dados (D10, D20, D100)

O código foi atualizado para ir além do dado comum de 6 faces. Agora, ele suporta o sistema de RPG e sorteios maiores.

**O que mudou:**

1. **A Lista de Opções:**
   Foi criada uma lista contendo `D6, D10, D20 e D100`. O aplicativo agora gera automaticamente um botão de seleção para cada um desses valores.
2. **Cálculo Dinâmico:**
   Em vez de ter uma regra fixa, o código agora "lê" o número do dado escolhido:
* Ele remove o "D" do nome (ex: "D20" vira `20`).
* Usa esse número como o limite máximo do sorteio.


3. **A Regra do Sorteio:**
   Para todos os novos dados, foi aplicada a correção `+ 1`.
* **Como funciona:** O computador começa a contar do **0**. Então, em um **D100**, ele sortearia de 0 a 99. Com o `+ 1`, o resultado fica corretamente entre **1 e 100**.



**Resumo visual:**

* **D10:** Sorteia de 1 a 10.
* **D20:** Sorteia de 1 a 20 (ideal para RPG).
* **D100:** Sorteia de 1 a 100 (centena).