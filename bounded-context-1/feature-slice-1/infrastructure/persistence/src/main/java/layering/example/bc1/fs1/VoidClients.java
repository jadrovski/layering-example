package layering.example.bc1.fs1;

import java.util.Optional;

public class VoidClients implements Clients {
  @Override
  public Optional<Client> find(long id) {
    return Optional.empty();
  }

  @Override
  public void add(Client client) {
  }
}
