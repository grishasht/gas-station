package ua.kpi.dziuba.gasstation.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.dziuba.gasstation.model.ITariff;
import ua.kpi.dziuba.gasstation.model.impl.Tariff;
import ua.kpi.dziuba.gasstation.repository.ITariffRepository;
import ua.kpi.dziuba.gasstation.service.ITariffService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TariffService implements ITariffService {

    private ITariffRepository tariffRepository;

    @Override
    public List<ITariff> getAllTariffs() {
        final Iterable<Tariff> tariffIterable = tariffRepository.findAll();

        return StreamSupport.stream(tariffIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setTariffRepository(ITariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }
}
