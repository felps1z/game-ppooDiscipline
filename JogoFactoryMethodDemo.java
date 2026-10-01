public class JogoFactoryMethodDemo {

    interface Inimigo {
        void atacar();
    }

    static class AnimalMutante implements Inimigo {
        public void atacar() {
            System.out.println("Animal mutante ataca o jogador!");
        }
    }

    static class Cangaceiro implements Inimigo {
        public void atacar() {
            System.out.println("Cangaceiro ataca o jogador!");
        }
    }

    static class Criminoso implements Inimigo {
        public void atacar() {
            System.out.println("Criminoso ataca o jogador!");
        }
    }

    static abstract class Localizacao {
        // Factory Method
        public abstract Inimigo criarInimigo();

        // Operação que usa o produto, sem saber qual é
        public void receberJogador() {
            Inimigo inimigo = criarInimigo();
            inimigo.atacar();
        }
    }

    static class Amazonia extends Localizacao {
        public Inimigo criarInimigo() {
            return new AnimalMutante();
        }
    }

    static class Sertao extends Localizacao {
        public Inimigo criarInimigo() {
            return new Cangaceiro();
        }
    }

    static class RioDeJaneiro extends Localizacao {
        public Inimigo criarInimigo() {
            return new Criminoso();
        }
    }

    public static void main(String[] args) {
        Localizacao amazonia = new Amazonia();
        Localizacao sertao = new Sertao();
        Localizacao rio = new RioDeJaneiro();

        System.out.println("Jogador entrando na Amazônia:");
        amazonia.receberJogador();

        System.out.println("Jogador entrando no Sertão:");
        sertao.receberJogador();

        System.out.println("Jogador entrando no Rio de Janeiro:");
        rio.receberJogador();
    }
}