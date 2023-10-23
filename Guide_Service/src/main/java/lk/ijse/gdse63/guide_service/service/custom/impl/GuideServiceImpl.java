package lk.ijse.gdse63.guide_service.service.custom.impl;

import lk.ijse.gdse63.guide_service.dto.GuidDTO;
import lk.ijse.gdse63.guide_service.entity.Guide;
import lk.ijse.gdse63.guide_service.repo.GuideRepo;
import lk.ijse.gdse63.guide_service.response.Response;
import lk.ijse.gdse63.guide_service.service.custom.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class GuideServiceImpl implements GuideService {

    @Autowired
    private Response response;

    @Autowired
    private GuideRepo guideRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(GuidDTO guidDTO) {
        if (search(guidDTO.getGuideId()).getData() == null) {
            guideRepo.save(modelMapper.map(guidDTO, Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully saved!", null);
        }
        throw new RuntimeException("Guide already exists!");
    }

    @Override
    public Response update(GuidDTO guidDTO) {
        if (search(guidDTO.getGuideId()).getData() != null) {
            guideRepo.save(modelMapper.map(guidDTO, Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully updated!", null);
        }
        throw new RuntimeException("Guide does not exists!");
    }

    @Override
    public Response delete(String id) {
        if (search(id).getData() != null) {
            guideRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully deleted!", null);
        }
        throw new RuntimeException("Guide does not exists!");

    }

    @Override
    public Response search(String id) {
        Optional<Guide> guide = guideRepo.findById(id);
        if (guide.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guide Successfully retrieved!", modelMapper.map(guide.get(),GuidDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Guide does not exists!", null);

    }

    @Override
    public Response getAll() {
        List<Guide> guide = guideRepo.findAll();
        if (!guide.isEmpty()) {
            ArrayList<GuidDTO> guidDTOS = new ArrayList<>();
            guide.forEach((guides) -> {
                guidDTOS.add(modelMapper.map(guides, GuidDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guide Successfully retrieved!", guidDTOS);
        }
        throw new RuntimeException("No Guide found in the database!");

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }


}
