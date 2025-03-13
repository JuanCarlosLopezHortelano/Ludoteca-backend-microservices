package com.ccsw.tutorial_prestamo.prestamo;

import com.ccsw.tutorial_prestamo.common.criteria.SearchCriteria;
import com.ccsw.tutorial_prestamo.prestamo.model.Prestamo;
import com.ccsw.tutorial_prestamo.prestamo.model.PrestamoDto;
import com.ccsw.tutorial_prestamo.prestamo.model.PrestamoSearchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    public Page<Prestamo> findPage(PrestamoSearchDto dto, Long id_game, Long id_client, String filterDate) {

        PrestamoSpecification gameSpec = new PrestamoSpecification(new SearchCriteria("game.id", ":", id_game));
        PrestamoSpecification clientSpec = new PrestamoSpecification(new SearchCriteria("client.id", ":", id_client));
        PrestamoSpecification dateLoanSpec = new PrestamoSpecification(new SearchCriteria("loanDate", "<=", filterDate));
        PrestamoSpecification dateReturnSpec = new PrestamoSpecification(new SearchCriteria("returnDate", ">=", filterDate));
        //PrestamoSpecification dateSpec = new PrestamoSpecification(new SearchCriteria("loanDate-returnDate", "between", filterDate));
        Specification<Prestamo> spec = Specification.where(clientSpec).and(gameSpec).and(dateLoanSpec).and(dateReturnSpec);

        return this.prestamoRepository.findAll(spec, dto.getPageable().getPageable());

    }

    @Override
    public void delete(Long id) throws Exception {
        if (this.prestamoRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not Exist");
        }

        this.prestamoRepository.deleteById(id);
    }

    @Override
    public void save(PrestamoDto dto) {
        Prestamo prestamo = new Prestamo();

        BeanUtils.copyProperties(dto, prestamo, "id", "game", "client");
        prestamo.setId_client(dto.getClient().getId());
        prestamo.setId_game(dto.getGame().getId());
        // if (checkSave(prestamo)) {

        this.prestamoRepository.save(prestamo);

    }

}

