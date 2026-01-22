package app.repository;

import app.model.Library;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    private final List<Library> libraries = new ArrayList<>();

    public void save(Library library) { libraries.add(library); }

    public void update(Library library) {
        delete(library.getId());
        libraries.add(library);
    }

    public void delete(int id) { libraries.removeIf(l -> l.getId() == id); }

    public Library findById(int id) {
        return libraries.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public long count() { return libraries.size(); }

    public List<Library> findAllByOrderByName() {
        return libraries.stream()
                .sorted(Comparator.comparing(Library::getName))
                .collect(Collectors.toList());
    }

    public List<Library> findByCity(String city) {
        return libraries.stream()
                .filter(l -> l.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}
