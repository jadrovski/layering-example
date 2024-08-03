package layering.example.bc1.fs1;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MapClients implements Clients {
  private final Map<Long, ClientRow> storage = new ConcurrentHashMap<>();

  @Override
  public Optional<Client> find(long id) {
    return Optional.ofNullable(storage.get(id)).map(this::restore);
  }

  @Override
  public void add(Client client) {
    this.storage.put(client.id(), new ClientRow(client.id(), client.name()));
  }

  private Client restore(ClientRow row) {
    return new Client(row.id(), row.name());
  }

  record ClientRow(long id, String name) {
  }
}
