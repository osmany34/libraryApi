package yelek.libraryApi.api;

import yelek.libraryApi.business.abstracts.IPublisherService;
import yelek.libraryApi.dto.request.publisher.PublisherSaveRequest;
import yelek.libraryApi.dto.request.publisher.PublisherUpdateRequest;
import yelek.libraryApi.dto.response.PublisherResponse;
import yelek.libraryApi.core.config.IModelMapperService;
import yelek.libraryApi.core.result.Result;
import yelek.libraryApi.core.result.ResultData;
import yelek.libraryApi.core.utilities.ResultHelper;
import yelek.libraryApi.entities.Publisher;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final IPublisherService publisherService;
    private final IModelMapperService modelMapper;

    public PublisherController(IPublisherService publisherService, IModelMapperService modelMapper) {
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest) {
        Publisher savePublisher = this.modelMapper.forRequest().map(publisherSaveRequest, Publisher.class);
        this.publisherService.save(savePublisher);
        PublisherResponse publisherResponse = this.modelMapper.forResponse().map(savePublisher, PublisherResponse.class);
        return ResultHelper.created(publisherResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id") int id) {
        Publisher publisher = this.publisherService.get(id);
        PublisherResponse publisherResponse = this.modelMapper.forResponse().map(publisher, PublisherResponse.class);
        return ResultHelper.success(publisherResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest) {
        Publisher updatePublisher = this.modelMapper.forRequest().map(publisherUpdateRequest, Publisher.class);
        this.publisherService.update(updatePublisher);
        PublisherResponse publisherResponse = this.modelMapper.forResponse().map(updatePublisher, PublisherResponse.class);
        return ResultHelper.success(publisherResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.publisherService.delete(id);
        return ResultHelper.ok();
    }
}