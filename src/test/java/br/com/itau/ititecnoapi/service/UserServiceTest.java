package br.com.itau.ititecnoapi.service;

import br.com.itau.ititecnoapi.model.Config;
import br.com.itau.ititecnoapi.repository.ConfigRepository;
import br.com.itau.ititecnoapi.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.passay.RuleResult;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private ConfigRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMinLengthFalse() {

        Config configMinLengthFalse = Config.builder()
                .minLength(6)
                .maxLength(14)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthFalse);
        RuleResult result = service.valid("Ted1?");
        assertEquals("TOO_SHORT", result.getDetails().get(0).getErrorCode());
        assertEquals(result.isValid(), false);

        verify(repository, times(1)).findFirstByOrderByDateTimeDesc();

    }

    @Test
    public void testMinLengthTrue() {

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(14)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("Tedy1?");
        assertEquals(result.isValid(), true);

    }

    @Test
    public void testMaxLengthFalse(){

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("Tedy123456?");
        assertEquals("TOO_LONG", result.getDetails().get(0).getErrorCode());
        assertEquals(result.isValid(), false);

        verify(repository, times(1)).findFirstByOrderByDateTimeDesc();

    }

    @Test
    public void testMaxLengthTrue(){

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("Tedy12345?");
        assertEquals(result.isValid(), true);

    }

    @Test
    public void testUpperCaseFalse(){

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("tedy12345?");
        assertEquals(result.isValid(), false);
        assertEquals("INSUFFICIENT_UPPERCASE", result.getDetails().get(0).getErrorCode());

        verify(repository, times(1)).findFirstByOrderByDateTimeDesc();

    }

    @Test
    public void testUpperCaseTrue(){

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("Tedy12345?");
        assertEquals(result.isValid(), true);

    }

    @Test
    public void testLowerCaseFalse(){

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("TEDY12345?");
        assertEquals(result.isValid(), false);
        assertEquals("INSUFFICIENT_LOWERCASE", result.getDetails().get(0).getErrorCode());

        verify(repository, times(1)).findFirstByOrderByDateTimeDesc();
    }

    @Test
    public void testLowerCaseTrue(){

        Config configMinLengthTrue = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(configMinLengthTrue);
        RuleResult result = service.valid("Tedy12345?");
        assertEquals(result.isValid(), true);

    }

    @Test
    public void testDigitTrue(){

        Config config = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(config);
        RuleResult result = service.valid("Tedyabcd1?");
        assertEquals(result.isValid(), true);

    }

    @Test
    public void testDigitFalse(){

        Config config = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(config);
        RuleResult result = service.valid("Tedyabcde?");
        assertEquals(result.isValid(), false);
        assertEquals("INSUFFICIENT_DIGIT", result.getDetails().get(0).getErrorCode());

        verify(repository, times(1)).findFirstByOrderByDateTimeDesc();
    }

    @Test
    public void testSpecialTrue(){

        Config config = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(config);
        RuleResult result = service.valid("Tedyabc12@");
        assertEquals(result.isValid(), true);

    }

    @Test
    public void testSpecialFalse(){

        Config config = Config.builder()
                .minLength(6)
                .maxLength(10)
                .upperCase(1)
                .lowerCase(1)
                .digit(1)
                .special(1)
                .build();

        when(repository.findFirstByOrderByDateTimeDesc()).thenReturn(config);
        RuleResult result = service.valid("Tedyabc123");
        assertEquals(result.isValid(), false);
        assertEquals("INSUFFICIENT_SPECIAL", result.getDetails().get(0).getErrorCode());

        verify(repository, times(1)).findFirstByOrderByDateTimeDesc();
    }

}
