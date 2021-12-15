package com.study.springcloud;



import com.study.springcloud.client.KakaoOpenApiClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
//@RestClientTest(FeignService.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class ExternalApiTest {


    @Autowired
    MockRestServiceServer mockRestServiceServer;

    @Autowired
    FeignService feignService;

    @MockBean
    KakaoOpenApiClient kakaoOpenApiClient;

    @Test
    public void apiTest() {
        String json = "{\"documents\":[{\"contents\":\"with lowdown and Markdown.pl Make a static site with find(1), grep(1), and lowdown or Markdown.pl \\u003cb\\u003essg\\u003c/b\\u003e is a static site generator written in shell. Optionally it converts Markdown files to HTML with...\",\"datetime\":\"2018-03-28T23:24:37.000+09:00\",\"title\":\"Usage\",\"url\":\"https://www.romanzolotarev.com/ssg.html\"},{\"contents\":\"2022년 시즌에 대한 내용은 \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스/2022년 문서 , 2022 시즌 현황에 대한 내용은 \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스/2022년/스토브리그 문서 참고하십시오. KBO 리그 소속 구단 [ 펼치기 · 접기 ] kt wiz 두산 베어스 삼성...\",\"datetime\":\"2021-11-19T00:00:00.000+09:00\",\"title\":\"\\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스 - 나무위키\",\"url\":\"https://namu.wiki/w/SSG%20%EB%9E%9C%EB%8D%94%EC%8A%A4\"},{\"contents\":\"네이버페이 · 카카오페이 · 페이코 · PayPal 물류유통 서비스사 스마일페이 · SK페이 · L.PAY · \\u003cb\\u003eSSG\\u003c/b\\u003e PAY 핀테크 서비스사 차이 · 토스 · 머니트리 · 케이페이 · 유비페이 교통카드사 티머니페이 증권사...\",\"datetime\":\"2021-11-16T00:00:00.000+09:00\",\"title\":\"\\u003cb\\u003eSSG\\u003c/b\\u003e PAY - 나무위키\",\"url\":\"https://namu.wiki/w/SSG%20PAY\"},{\"contents\":\"KT 위즈와 \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스의 마지막 맞대결이 벌어진다. 정규시즌 최종전이다. KT위즈와 \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스는 30일 인천\\u003cb\\u003eSSG\\u003c/b\\u003e랜더스필드에서 올해 정규 시즌 마지막 경기를 펼친다. 두 팀 모두 한 순간도 방심할 수 없는 경기...\",\"datetime\":\"2021-11-22T19:08:40.000+09:00\",\"title\":\"[30일 프리뷰] KT 소형준 vs \\u003cb\\u003eSSG\\u003c/b\\u003e 김건우, 누가 마지막에 웃을까\",\"url\":\"https://www.koreabaseball.com/News/Preview/View.aspx?bdSe=49495\"},{\"contents\":\"[OSEN=홍지수 기자] \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스는 16일 \\u0026#34;추신수(39)와 연봉 27억 원에 2022시즌 재계약을 맺었다\\u0026#34;고 발표했다. 동시에 추신수의 재계약 소감이 전해졌다. 올해 \\u003cb\\u003eSSG\\u003c/b\\u003e에서 KBO리그 첫 시즌을 마친 추신수는 팀의...\",\"datetime\":\"2021-11-16T16:06:15.000+09:00\",\"title\":\"[추신수, 내년에도 \\u003cb\\u003eSSG\\u003c/b\\u003e와 동행 결정…\\u0026#34;가장 큰 목표는 PS\\u0026#34; [일문일답]\",\"url\":\"https://www.koreabaseball.com/News/KboPhoto/View.aspx?bdSe=342601\"},{\"contents\":\"센터 하루 최대 3000건의 온라인 주문 배송 내년 목표로 본격적인 IPO 절차 돌입… 대표 주간사 선정 완료 \\u003cb\\u003eSSG\\u003c/b\\u003e닷컴은 지난 9월 중순 리뉴얼 공사를 마친 이마트 이천점 PP센터(Picking\\u0026amp;Packing)의 시범운영을...\",\"datetime\":\"2021-11-04T18:12:34.000+09:00\",\"title\":\"\\u003cb\\u003eSSG\\u003c/b\\u003e닷컴, 대형 PP센터 확대 ‘속도‘\",\"url\":\"https://www.whitepaper.co.kr/news/articleView.html?idxno=210688\"},{\"contents\":\"프로야구 \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스의 구단주인 정용진 신세계 그룹 부회장이 간판 타자 최정(34)을 응원했다. \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스 구단주인 정용진 신세계 그룹 부회장이 지난 27일 인천 \\u003cb\\u003eSSG\\u003c/b\\u003e 랜더스필드에서 열린 KBO리그 두산 베어스...\",\"datetime\":\"2021-10-28T15:07:59.000+09:00\",\"title\":\"정용진 \\u003cb\\u003eSSG\\u003c/b\\u003e 구단주 ”마이 히어로 최정”\",\"url\":\"http://isplus.live.joins.com/news/article/article.asp?total_id=24159795\\u0026ctg=1401\\u0026tm=i_b\\u0026tag=\"},{\"contents\":\"목 차 \\u003cb\\u003eSSG\\u003c/b\\u003e 페이 , 쓱 페이 , \\u003cb\\u003eSSG\\u003c/b\\u003e PAY 온/오프라인 사용처 알아보기 쓱 페이 란? #1. 쓱 페이 이용 조건 #2. 쓱 페이 회원 가입 방법 #3. 쓱 페이 신용 카드 등록 방법 #4. 쓱 페이 결재 방법 오프라인 가맹점...\",\"datetime\":\"2021-11-23T11:49:51.000+09:00\",\"title\":\"\\u003cb\\u003eSSG\\u003c/b\\u003e 페이 사용처 , 쓱 페이 사용처 , \\u003cb\\u003eSSG\\u003c/b\\u003e PAY 사용처\",\"url\":\"http://sweetanalyst.com/ssg-pay-store/amp/\"},{\"contents\":\"선제적으로 관련 인프라를 준비해온 조직들은 보다 유리한 환경에서 비즈니스를 영위해나가고 있다. \\u003cb\\u003eSSG\\u003c/b\\u003e닷컴(\\u003cb\\u003eSSG\\u003c/b\\u003e.COM)은 이러한 데이터의 중요성을 선제적으로 인식하고 대응해온 기업 중 하나다. 상품 검색...\",\"datetime\":\"2021-11-22T17:16:34.000+09:00\",\"title\":\"[구축사례] \\u003cb\\u003eSSG\\u003c/b\\u003e닷컴, 데이터 관리도 ‘쓱(\\u003cb\\u003eSSG\\u003c/b\\u003e)’\",\"url\":\"http://www.comworld.co.kr/news/articleView.html?idxno=50178\"},{\"contents\":\"◆…사진=\\u003cb\\u003eSSG\\u003c/b\\u003e페이 제공 신세계 그룹의 결제 서비스 \\u0026#39;\\u003cb\\u003eSSG\\u003c/b\\u003e페이\\u0026#39;는 고객들의 상품권 이용 편의를 높이고자 \\u0026#39;스크래치형 신세계 상품권\\u0026#39;을 \\u003cb\\u003eSSG\\u003c/b\\u003e머니로 전환할 경우 총 3000만원의 \\u003cb\\u003eSSG\\u003c/b\\u003e머니를 증정하는 이벤트를 20일...\",\"datetime\":\"2021-11-24T16:09:39.000+09:00\",\"title\":\"\\u003cb\\u003eSSG\\u003c/b\\u003e페이, 지류 신세계 상품권 \\u003cb\\u003eSSG\\u003c/b\\u003e머니 전환 이벤트 진행\",\"url\":\"http://seyul.com/news/menu1_view.html?newsid=361148\\u0026type=17\\u0026page=2\"}],\"meta\":{\"is_end\":false,\"pageable_count\":449,\"total_count\":689153}}\n";
        mockRestServiceServer.expect(requestTo("https://dapi.kakao.com/v2/search/web"))
                .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));

        ResKakaoApi resKakaoApi = kakaoOpenApiClient.searchDaumWeb("AA");

        System.out.println(resKakaoApi);

    }

}
