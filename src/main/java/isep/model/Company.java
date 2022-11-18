package isep.model;

import isep.model.store.EntityStore;

/**
 * @author André Barros <1211299@isep.ipp.pt>
 * @author Carlos Lopes <1211277@isep.ipp.pt>
 * @author Ricardo Moreira <1211285@isep.ipp.pt>
 * @author Tomás Lopes <1211289@isep.ipp.pt>
 * @author Tomás Russo <1211288@isep.ipp.pt>
 */
public class Company {
  private final DistributionNetwork distributionNetwork;
  private final EntityStore entityStore;

  public Company() {
    this.distributionNetwork = new DistributionNetwork();
    this.entityStore = new EntityStore();
  }

  public DistributionNetwork getDistributionNetwork() {
    return distributionNetwork;
  }

  public EntityStore getEntityStore() {
    return entityStore;
  }
}
