import java.util.*;
import java.util.LinkedList;

/**
 * Classe implantant le gestionnaire d'événements.
 */
public class EventManager {
    /** Date courante du gestionnaire. */
    private long currentDate = 0;
    /** Liste des événements ( de type LinkedList ). */
    private LinkedList<Event> events;

    /** Ajoute un événement à la liste. */
    public void addEvent(Event e) {
        events.add(e);
    }

    /**
     * Met à jour la date courante du gestionnaire.
     * @param currentDate Nouvelle date.
     */
    public void setCurrentDate(long currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * Récupère la date courante du gestionnaire.
     * @return la date courante (type long).
     */
    public long getCurrentDate() {
        return currentDate;
    }

    /**
     * Méthode next pour incrémenter la date courante et exécuter les événements non encore exécutés et dont la date ne dépasse pas la date courante.
     */
    public void next() {
        this.currentDate = this.currentDate + 1;
        for (Event e : this.events) {
            if (e.getDate() == this.currentDate) {
                e.execute();
            }
        }
    }

    /**
     * Constructeur du gestionnaire d'événements.
     * @param Liste des événements.
     * @param currentDate Date courante.
     */
    public EventManager(LinkedList<Event> events, long currentDate) {
        this.events = events;
        this.currentDate = currentDate;
    }

    /**
     * méthode retournant true ou false selon s'il reste des événements à exécuter ou pas.
     * @return
     */
    public boolean isFinished() {
        Iterator<Event> it = events.iterator();
        boolean isFinished = false;
        if (it.hasNext() == false) {
            isFinished = true;
        }
        return isFinished;
    }

    /**
     * méthode permettant de réinitialiser le gestionnaire à son état initial.
      */
    public void restart() {
        this.currentDate = 0;
        for (Event e : this.events) {
            if (e.getDate() == this.currentDate) {
                e.execute();
            }
        }
    }
}
