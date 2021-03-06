package jp.gr.java_conf.stardiopside.ark.service;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jp.gr.java_conf.stardiopside.ark.data.entity.PostalCode;
import jp.gr.java_conf.stardiopside.ark.data.repository.PostalCodeRepository;

@Named
@Singleton
public class PostalCodeServiceImpl implements PostalCodeService {

    private final PostalCodeRepository postalCodeRepository;

    public PostalCodeServiceImpl(PostalCodeRepository postalCodeRepository) {
        this.postalCodeRepository = postalCodeRepository;
    }

    @Override
    @Transactional
    public Page<PostalCode> search(Pageable pageable) {
        Sort sort = new Sort(Sort.Direction.ASC, "localGovernmentCode", "postalCode", "kanaPrefectureName",
                "kanaMunicipalityName", "kanaAreaName");
        return postalCodeRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort));
    }
}
