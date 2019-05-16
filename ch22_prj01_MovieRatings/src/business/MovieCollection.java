package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieCollection {
	
	List<Movie> movies;
	
	public MovieCollection() {
		movies = new ArrayList<>();
	}
	
	public MovieCollection(List<Movie> movies) {
		this.movies = movies;
	}

	public void add(Movie movie) {
		movies.add(movie);
	}
	
	public List<Movie> filterMovies(Predicate<Movie> condition) {
		// should use the Predicate function parameter to filter the movies list of movies, 
		// and it should return a list of Movie objects that meet the condition in the filter
		List<Movie> filteredMovies = new ArrayList<>();
		for (Movie m : movies) {
			if (condition.test(m)) {
				filteredMovies.add(m);
			}
			
		}
		
		return filteredMovies;
		
	}
	
	public double getLowestRating() {
		
		double minRating = movies.stream().map(m -> m.getRating()).reduce(Double.MAX_VALUE, (a, b) -> Math.min(a, b));
		
		
		
		return minRating;
		// should use a map and reduce operation to get the movie ratings
		
	}
	
	public double getHighestRating() {
		
		double maxRating = movies.stream().map(m -> m.getRating()).reduce(0.0, (a, b) -> Math.max(a, b));
		return maxRating;
		// should use a map and reduce operation to get the movie ratings

		
	}
	
	public double getAverageRating() {
		
		double ratingSum = movies.stream().map(m -> m.getRating()).reduce(0.0, (a, b) -> a + b);
		double ratingTotal = movies.size();
		double avgRating = ratingSum / ratingTotal;
		
	
		return avgRating;
		// should use a map and reduce operation to get the movie ratings

		
	}
	
	public int getSize() {
		int numMovies = movies.size();
		return numMovies;
		
	}
	
	
	public List<Movie> getMovies() {
		
		return this.movies;
	}
	
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	@Override
	public String toString() {
		return "MovieCollection [movies=" + movies + "]";
	}
	
	

}
