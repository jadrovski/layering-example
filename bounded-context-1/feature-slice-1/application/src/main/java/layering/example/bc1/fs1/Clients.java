package layering.example.bc1.fs1;

import java.util.Optional;

public interface Clients {
  Optional<Client> find(long id);
  void add(Client client);
}
