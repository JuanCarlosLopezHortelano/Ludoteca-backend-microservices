package com.ccsw.tutorial_prestamo.prestamo;

import com.ccsw.tutorial_prestamo.client.ClientClient;
import com.ccsw.tutorial_prestamo.client.model.ClientDto;
import com.ccsw.tutorial_prestamo.game.GameClient;
import com.ccsw.tutorial_prestamo.game.model.GameDto;
import com.ccsw.tutorial_prestamo.prestamo.model.Prestamo;
import com.ccsw.tutorial_prestamo.prestamo.model.PrestamoDto;
import com.ccsw.tutorial_prestamo.prestamo.model.PrestamoSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Prestamo", description = "API of Prestamo")
@RequestMapping(value = "/prestamo")
@RestController()
@CrossOrigin(origins = "*")

public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @Autowired
    ClientClient clientClient;

    @Autowired
    GameClient gameClient;

    @Autowired
    ModelMapper mapper;

    /**
     * Metodo para recuperar un listado paginado de {@link Prestamo}
     *
     * @param dto dto de busqueda
     * @return {@link Page} de {@link PrestamoDto}
     *
     */
    @Operation(summary = "Find Page", description = "Method that return a page of Prestamos")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PrestamoDto> findPage(@RequestBody PrestamoSearchDto dto, @RequestParam(value = "id_game", required = false) Long id_game, @RequestParam(value = "id_client", required = false) Long id_client,
            @RequestParam(value = "filterDate", required = false) String filterDate) {

        List<ClientDto> clients = clientClient.findAll();
        List<GameDto> games = gameClient.findAll();

        Page<Prestamo> page = this.prestamoService.findPage(dto, id_game, id_client, filterDate);

        List<PrestamoDto> prestamoDtos = page.getContent().stream().map(prestamo -> {
            PrestamoDto prestamoDto = new PrestamoDto();

            prestamoDto.setId(prestamo.getId());
            prestamoDto.setLoanDate(prestamo.getLoanDate());
            prestamoDto.setReturnDate(prestamo.getReturnDate());
            prestamoDto.setClient(clients.stream().filter(client -> client.getId().equals(prestamo.getId_client())).findFirst().orElse(null));
            prestamoDto.setGame(games.stream().filter(game -> game.getId().equals(prestamo.getId_game())).findFirst().orElse(null));

            return prestamoDto;
        }).collect(Collectors.toList());

        return new PageImpl<>(prestamoDtos, page.getPageable(), page.getTotalElements());
    }

    /**
     * Metodo para eliminar un  {@link Prestamo}
     *
     * @param id de la entidad
     */
    @Operation(summary = "Delete", description = "Method that deletes a Prestamo")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.prestamoService.delete(id);
    }

    /**
     * Método para crear  un {@link Prestamo}
     *
     * @param dto datos de la entidad
     */
    @Operation(summary = "Save ", description = "Method that saves a Prestamo")
    @RequestMapping(path = { "" }, method = RequestMethod.PUT)
    public void save(@RequestBody PrestamoDto dto) {
        this.prestamoService.save(dto);

    }

    @RequestMapping(path = { "/test" }, method = RequestMethod.GET)
    public List<GameDto> test() {
        List<GameDto> listas = gameClient.findAll();
        System.out.println("Lista de juegos: ");
        listas.forEach(game -> System.out.println(game.getAuthorDto()));

        return listas;

    }

}
