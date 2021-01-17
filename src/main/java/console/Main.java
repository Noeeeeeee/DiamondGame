//package console;
//
//import manager.GameManager;
//import model.Carte;
//import model.createurs.CreateurCarte;
//import model.createurs.CreateurCarteSimple;
//
//public class Main {
//    package console;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import manager.GameManager;
//import model.Carte;
//import model.Joueur;
//import model.Partie;
//import model.createurs.CreateurCarte;
//import model.createurs.CreateurCarteSimple;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//    public class Main {
//
//        public static void main(String[] args) throws Exception {
//            GameManager man = GameManager.getInstance();
//            man.creerPartie();
//            CreateurCarte c = new CreateurCarteSimple();
//            c.CreateurCarteDiamant(man.p);
//            for (Carte cartee : man.getCartes()) {
//                System.out.println("avant remove");
//                System.out.println(cartee);
//
//            }
//            System.out.println("avant" + man.getCartes().size());
//
////
////        for(Carte carte : man.getCartes()){
////            man.getCartes().remove(carte);
////            System.out.println("après remove");
////
////        }
//
//            cartes.removeAll(cartes);
//            System.out.println(cartes.size());
////        Iterator<Carte> Iterateur = man.getCartes().iterator();
////        while (Iterateur.hasNext()){
////                Iterateur.remove();
////                break;
////            }
////        }
//
//
//        }
//
//}
