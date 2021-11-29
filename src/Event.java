/** Fournit une implantation de la classe abstraite Event */
public abstract class Event {
    /** Date de l'événement. */
    private long date;

    /**
     * récupère la date de l'événement.
     * @return retourne la date de l'événement ( de type long ) .
      */
    public long getDate() {
        return date;
    }

    /**
     * Constructeur d'un événement.
     * @param date date de l'événement.
     */
    public Event(long date) {
        this.date = date;
    }

    /**
     * méthode abstraite qui doit être redéfinie dans les classes qui vont hériter de Event , et qui permet l'exécution de l'événement.
     */
    abstract public void execute();
}
