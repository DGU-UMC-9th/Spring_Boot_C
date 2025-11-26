package com.example.demo.domain.review.service.command;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.exception.MemberException;
import com.example.demo.domain.member.exception.code.MemberErrorCode;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.review.converter.ReviewConverter;
import com.example.demo.domain.review.dto.req.ReviewReqDTO;
import com.example.demo.domain.review.entity.Review;
import com.example.demo.domain.review.repository.ReviewRepository;
import com.example.demo.domain.store.entity.Store;
import com.example.demo.domain.store.exception.StoreException;
import com.example.demo.domain.store.exception.code.StoreErrorCode;
import com.example.demo.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;


    @Override
    public Review createReview(ReviewReqDTO.ReviewRegisterDTO request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 3. 리뷰 엔티티 생성
        Review review = ReviewConverter.toEntity(request, member, store);

        // 4. DB 저장
        return reviewRepository.save(review);
    }
}
