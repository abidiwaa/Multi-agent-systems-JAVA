import java.util.LinkedList;

public class TestEventManager{
    public static void main ( String [] args ) throws InterruptedException {
         // On crée un simulateur
         LinkedList<Event> l = new LinkedList<>();
         EventManager manager = new EventManager (l,0) ;

         // On poste un événement [ PING ] tous les deux pas de temps
         for (int i = 2 ; i <= 10 ; i += 2) {
             manager . addEvent (new MessageEvent (i , " [ PING ]") ) ;
             }
         // On poste un évé nement [ PONG ] tous les trois pas de temps
         for (int i = 3 ; i <= 9 ; i += 3) {
             manager . addEvent (new MessageEvent (i , " [ PONG ]") ) ;
             }

         while ( !manager . isFinished () ) {
             manager . next () ;
            Thread . sleep (1000) ;
             }
        }
}
