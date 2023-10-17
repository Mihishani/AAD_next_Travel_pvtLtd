package lk.ijse.gdse63.package_detail_service.service.custom.impl;

import lk.ijse.gdse63.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.package_detail_service.entity.Packagedetail;
import lk.ijse.gdse63.package_detail_service.repo.PackageDetailRepo;
import lk.ijse.gdse63.package_detail_service.response.Response;
import lk.ijse.gdse63.package_detail_service.service.custom.PackageDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PackageDetailServiceImpl implements PackageDetailService {

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageDetailRepo packageDetailRepo;
    @Override
    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(PackageDetailDTO packageDetailDTO) {
        if (search(packageDetailDTO.getPackagedetailId()).getData() == null) {
            packageDetailRepo.save(modelMapper.map(packageDetailDTO, Packagedetail.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Detail Successfully saved!", null);
        }
        throw new RuntimeException("Package Detail already exists!");


    }

    @Override
    public Response update(PackageDetailDTO packageDetailDTO) {
        if (search(packageDetailDTO.getPackagedetailId()).getData() != null) {
            packageDetailRepo.save(modelMapper.map(packageDetailDTO, Packagedetail.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Detail Successfully updated!", null);
        }
        throw new RuntimeException("Package Detail does not exists!");

    }

    @Override
    public Response delete(String id) {
        if (search(id).getData() != null) {
            packageDetailRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(), "Package Detail Successfully deleted!", null);
        }
        throw new RuntimeException("package Detail does not exists!");


    }

    @Override
    public Response search(String id) {
        Optional<Packagedetail> packagedetail = packageDetailRepo.findById(id);
        if (packagedetail.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Package Detail Successfully retrieved!", modelMapper.map(packagedetail.get(),PackageDetailDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package Detail does not exists!", null);

    }

    @Override
    public Response getAll() {
        List<Packagedetail>  packagedetails =  packageDetailRepo.findAll();
        if (! packagedetails.isEmpty()) {
            ArrayList<PackageDetailDTO>  packageDetailDTOS = new ArrayList<>();
            packagedetails.forEach((packagedetail) -> {
               packageDetailDTOS.add(modelMapper.map(packagedetail,PackageDetailDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Package Detail Successfully retrieved!", packageDetailDTOS);
        }
        throw new RuntimeException("No Detail found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
