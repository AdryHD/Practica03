package proyecto02.practica03;

public abstract class Movie implements IMovie {
    protected String name;
    protected String genre;
    protected int duration;
    protected int releaseYear;

    public Movie(String name, String genre, int duration, int releaseYear) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseYear = releaseYear;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }
}
