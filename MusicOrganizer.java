import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Muestra por pantalla todos los eslementos de la coleccion files
     */
    public void listAllFiles() {
        int index = 0;
        int contador = 1;
        while(index < files.size()) {
            String filename = files.get(index);
            System.out.println(contador + ". " + filename);
            index++;
            contador++;
        }
    }

    /**
     * pone una lista que contenga el string introducido en el parametro
     */
    public void listMatching(String searchString) {
        int filesSearched = 0;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
                filesSearched += 1;
            }
        }
        if (filesSearched == 0) {
            System.out.println("Error: No hay ningun archivo llamado así");
        }
    }

    /**
     * reproduce todas las canciones de un artista en concreto
     */
    public void playSamplesArtist(String searchString) {
        for (String filename : files) {
            if (filename.contains(searchString)) {
                player.playSample(filename);
            }
        }  
    }

    /**
     * elimina canciones buscando por texto
     */
    public void deleteSongsWithText(String searchString) {
        int contador = 0;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                files.remove(contador);
                contador += 1;
            }
        }
    }

    /**
     * Localiza el índice del primer archivo que se corresponde con
     * la cadena de búsqueda indicada .
     * @param searchString La cadena que hay que buscar.
     * @return El índice de la primera aparición o -1 si
     * no se encuentra ninguna correspondencia
     */
    public int findFirst(String searchString) {
        int index = 0;
        boolean found = false;
        while (index < files.size() && !found) {
            String filename = files.get(index);
            if (filename.contains(searchString)) {
                found = true;
            }
            else {
                index++;
            }
        }
        if (!found) {
            index = -1;
        }
        return index;
    }
}
