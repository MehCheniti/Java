class TestFigurer {

    public static void main(String[] args) {
        Rektangel r1 = new Rektangel(10.0, 12.5);
        Rektangel r2 = new Rektangel(5.5, 0);

        Sirkel s1 = new Sirkel(5.3);
        Sirkel s2 = new Sirkel(0);


        System.out.println("Tester Rektangel r1");
        if (r1.beregnAreal() == 125) {
            System.out.println("Riktig 1!");
        } else {
            System.out.println("Feil 1!");
        }

        if (r1.beregnOmkrets() == 45) {
            System.out.println("Riktig 2!");
        } else {
            System.out.println("Feil 2!");
        }


        System.out.println("Tester Rektangel r2");
        if (r2.beregnAreal() == 0) {
            System.out.println("Riktig 3!");
        } else {
            System.out.println("Feil 3!");
        }

        if (r2.beregnOmkrets() == 11) {
            System.out.println("Riktig 4!");
        } else {
            System.out.println("Feil 4!");
        }


        System.out.println("Tester Sirkel s1");
        if (Math.floor(s1.beregnAreal()) == 88) {
            System.out.println("Riktig 5!");
        } else {
            System.out.println("Feil 5!");
        }

        if (Math.floor(s1.beregnOmkrets()) == 33) {
            System.out.println("Riktig 6!");
        } else {
            System.out.println("Feil 6!");
        }


        System.out.println("Tester Sirkel s2");
        if (Math.floor(s2.beregnAreal()) == 0) {
            System.out.println("Riktig 7!");
        } else {
            System.out.println("Feil 7!");
        }

        if (Math.floor(s2.beregnOmkrets()) == 0) {
            System.out.println("Riktig 8!");
        } else {
            System.out.println("Feil 8!");
        }
    }
}
