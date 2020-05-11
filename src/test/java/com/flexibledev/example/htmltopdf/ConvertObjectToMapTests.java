package com.flexibledev.example.htmltopdf;

import com.flexibledev.example.htmltopdf.model.Agent;
import com.flexibledev.example.htmltopdf.model.Contract;
import com.flexibledev.example.htmltopdf.model.Signer;
import com.flexibledev.example.htmltopdf.utility.ObjectConverter;
import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by seonhyeonmin on 2020/05/08 6:41 오후
 */
public class ConvertObjectToMapTests {

    Signer lessor = new Signer("이율곡",
            "010-1234-5555",
            "인천광역시 계양구 계양산로 134번길 15 인우빌라 나동 102호",
            "870712-1xxxxxxx",
            "123-123-1234",
            "");
    Signer lessee = new Signer("홍길동",
            "",
            "서울특별시 강남구 서초동 xxx-xxx",
            "911225-1xxxxxxx",
            "",
            "");
    Agent agent = new Agent("다방 Hub",
            "한유순",
            "서울시 서초구 서초대로 301, 10층 다방",
            "299-86-00021",
            "02-554-9774");

    @Test
    void convertContractTest() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        // given
        Contract contract = new Contract("1234", lessor, lessee, agent);
        ObjectConverter converter = new ObjectConverter();

        // when
        Map<String, String> map = converter.toMap(contract);

        // then
        assertNotNull(map.get("contractNumber"));
        assertNotNull(map.get("lessor.phone"));
        assertNotNull(map.get("lessor.name"));
        assertNotNull(map.get("lessee.address"));
        assertNotNull(map.get("agent.phone"));
    }

}
