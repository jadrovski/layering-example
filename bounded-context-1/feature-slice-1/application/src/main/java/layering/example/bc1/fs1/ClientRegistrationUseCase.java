package layering.example.bc1.fs1;

public class ClientRegistrationUseCase {
  private final Clients clients;
  private final ClientIdentityGenerator identityGenerator;

  public ClientRegistrationUseCase(Clients clients, ClientIdentityGenerator identityGenerator) {
    this.clients = clients;
    this.identityGenerator = identityGenerator;
  }

  public void execute(Input input, Presenter presenter) {
    try {
      Client newClient = Client.register(identityGenerator.next(), input.clientName());
      this.clients.add(newClient);
      presenter.presentSuccess(new Output(newClient.id()));
    } catch (RuntimeException e) {
      presenter.presentFail();
    }
  }

  public record Input(String clientName) {
  }

  public record Output(long clientId) {
  }

  public interface Presenter {
    void presentSuccess(Output client);
    void presentFail();
  }
}
