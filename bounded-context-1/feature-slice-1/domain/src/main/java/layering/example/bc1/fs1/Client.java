package layering.example.bc1.fs1;

public class Client {
  private final long id;
  private final String name;

  Client(long id, String name) {
    this.id = id;
    this.name = name;
  }

  long id() {
    return id;
  }

  String name() {
    return name;
  }

  public static Client register(long id, String name) {
    return new Client(id, name);
  }
}
