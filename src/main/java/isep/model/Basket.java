package isep.model;

import java.util.Map;
import java.util.Set;
import isep.shared.exceptions.InvalidHubException;
import isep.shared.exceptions.InvalidOrderException;

/*
 * Basket class
 *
 * @author Carlos Lopes <1211277@isep.ipp.pt>
 */
public class Basket {
  private Map<Product, Integer> ordered;
  private ReceivedProducts received;
  private Enterprise hub;
  private Client client;

  /*
   * Constructor
   */
  public Basket(Map<Product, Integer> ordered, ReceivedProducts received, Enterprise hub,
      Client client) throws InvalidOrderException, InvalidHubException {
    setOrdered(ordered);
    setReceived(received);
    setHub(hub);
    setClient(client);
  }

  /*
   * Set of ordered products
   */
  private void setOrdered(Map<Product, Integer> ordered) throws InvalidOrderException {
    if (ordered == null)
      throw new IllegalArgumentException("Null ordered map is Invalid!");

    Integer sum = 0;
    for (Integer qnt : ordered.values())
      sum += qnt;

    if (sum == 0)
      throw new InvalidOrderException();

    this.ordered = ordered;
  }

  /*
   * Set of received products
   */
  private void setReceived(ReceivedProducts received) {
    if (received == null)
      throw new IllegalArgumentException("Null received map is Invalid!");

    this.received = received;
  }

  /*
   * Set hub
   */
  private void setHub(Enterprise enterprise) throws InvalidHubException {
    if (enterprise == null)
      throw new IllegalArgumentException("Null hub is Invalid!");
    if (!enterprise.isHub())
      throw new InvalidHubException();

    this.hub = enterprise;
  }

  /*
   * Set client
   */
  private void setClient(Client client) {
    if (client == null)
      throw new IllegalArgumentException("Null client is Invalid!");

    this.client = client;
  }

  public Client getClient() {
    return this.client;
  }

  public boolean isFromClient(Client client) {
    return this.client.equals(client);
  }

  public boolean isFromHub(Enterprise hub) {
    return this.hub.equals(hub);
  }

  /*
   * Get basket hub
   */
  public Enterprise getHub() {
    return hub;
  }

  /*
   * Get list of producers
   */
  public Set<Producer> getProducers() {
    return this.received.getProducers();
  }

  public int getNumberOfProducts() {
    return ordered.size();
  }

  public boolean isFullyFulfilled() {
    return getNumberOfFullySatisfiedProducts() == ordered.size();
  }

  public boolean isPartiallyFulfilled() {
    int numberOfFulfilledProducts =
        getNumberOfFullySatisfiedProducts() + getNumberOfPartiallySatisfiedProducts();

    return numberOfFulfilledProducts > 0 && numberOfFulfilledProducts < ordered.size();
  }

  public int getNumberOfFullySatisfiedProducts() {
    int count = 0;

    for (Product product : ordered.keySet()) {
      int orderedQuantity = ordered.get(product);

      if (received.matchesProductQuantity(product, orderedQuantity))
        count++;
    }

    return count;
  }

  public int getNumberOfNotSatisfiedProducts() {
    int count = 0;

    for (Product product : ordered.keySet())
      if (received.hasNotReceivedProduct(product))
        count++;

    return count;
  }

  public int getNumberOfPartiallySatisfiedProducts() {
    return ordered.size() - getNumberOfFullySatisfiedProducts() - getNumberOfNotSatisfiedProducts();
  }

  public boolean isFullySuppliedBy(Producer producer) {
    return received.getNumberOfDistinctProducers() == 1
        && received.getProducers().contains(producer);
  }

  public boolean isPartiallySuppliedBy(Producer producer) {
    // ? If is fully supplied by producer, then it is not partially supplied by producer
    return received.getNumberOfDistinctProducers() > 1
        && received.getProducers().contains(producer);
  }

  public int getQuantityOfSuppliedProduct(Producer producer, Product product) {
    return received.getQuantityOfSuppliedProduct(producer, product);
  }

  public Set<Product> getProducts() {
    return ordered.keySet();
  }
}
