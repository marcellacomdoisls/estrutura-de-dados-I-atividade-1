import java.util.Stack;
import java.util.Scanner;

public class VerificadorExpressao {

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite uma expressão matemática: ");
    String expressao = teclado.nextLine();
    if (verificarParametro(expressao)) {
      System.out.println("A expressão está com a parametrização correta.");
    } else {
      System.out.println("A expressão está com a parametrização incorreta.");
    }

    teclado.close();
  
  }

  public static boolean verificarParametro(String expressao) {
    Stack<Character> pilha = new Stack<>();

    for (int i = 0; i < expressao.length(); i++) {
      char caractere = expressao.charAt(i);
      if (caractere == '(' || caractere == '[' || caractere == '{') {
        pilha.push(caractere);
      } else if (caractere == ')' || caractere == ']' || caractere == '}') {
        if (pilha.isEmpty()) {
          return false;
        }
        char topo = pilha.pop();
        if ((caractere == ')' && topo != '(') ||
            (caractere == ']' && topo != '[') ||
            (caractere == '}' && topo != '{')) {
          return false;
        }
      }
    }

    return pilha.isEmpty();
  }
}
