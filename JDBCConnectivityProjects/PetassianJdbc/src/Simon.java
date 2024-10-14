import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.repository.OwnerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Simon implements OwnerRepository {
    @Override
    public void saveOwner(OwnerDTO owner) {

    }

    @Override
    public Optional<OwnerDTO> findOwner(int ownerId) {
        return Optional.empty();
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {

    }

    @Override
    public void deleteOwner(int ownerId) {

    }

    @Override
    public List<OwnerDTO> findAllOwners() {
        return Collections.emptyList();
    }
}
