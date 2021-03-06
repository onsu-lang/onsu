package onsu.tools.compiler;

public final class Main {
  public static void main(String[] args) {
    System.exit(new OnsuCompiler().run(System.in, System.out, System.err, args));
  }
}
