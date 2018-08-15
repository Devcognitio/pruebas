import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class EPREPAIDRQTxTest {
    private static final String BALANCE = "BALANCE";
    private static final String DETAIL = "DETAIL";
    private static final String LOAD = "LOAD";
    private static final String EPREPAIDRQ_BALANCE = "EPREPAIDRQ_BALANCE";
    private static final String EPREPAIDRQ_DETAIL = "EPREPAIDRQ_DETAIL";
    private static final String EPREPAIDRQ_LOAD = "EPREPAIDRQ_LOAD";

    @Spy
    EPREPAIDRQTx EPREPAIDRQTx = new EPREPAIDRQTx();

    @Mock
    TCFX tcfx;

    @Mock
    EPREPAIDRQ eprepaid;


    @Test
    public void processDebeRetornarLoadTransaccionBalanceCuandoEprepaidEsBalance()  throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        String xmlRequest= "";
        Object obj = null;

        Mockito.when(tcfx.getAny()).thenReturn(eprepaid);
        Mockito.when(eprepaid.getTYPE()).thenReturn(BALANCE);
        Mockito.doReturn("Prueba1").when(EPREPAIDRQTx).loadTransactionInfo(tcfx,EPREPAIDRQ_BALANCE, xmlRequest);

        String resp = EPREPAIDRQTx.process(tcfx, xmlRequest, obj);

        Assert.assertEquals("Prueba1", resp);
    }

    @Test
    public void processDebeRetornarLoadTransaccionDetailCuandoEprepaidEsDetail()  throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        String xmlRequest= "";
        Object obj = null;

        Mockito.when(tcfx.getAny()).thenReturn(eprepaid);
        Mockito.when(eprepaid.getTYPE()).thenReturn(DETAIL);
        Mockito.doReturn("Prueba2").when(EPREPAIDRQTx).loadTransactionInfo(tcfx,EPREPAIDRQ_DETAIL, xmlRequest);

        String resp = EPREPAIDRQTx.process(tcfx, xmlRequest, obj);

        Assert.assertEquals("Prueba2", resp);
    }

    @Test
    public void processDebeRetornarLoadTransaccionLoadCuandoEprepaidEsLoad()  throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        String xmlRequest= "";
        Object obj = null;

        Mockito.when(tcfx.getAny()).thenReturn(eprepaid);
        Mockito.when(eprepaid.getTYPE()).thenReturn(LOAD);
        Mockito.doReturn("Prueba3").when(EPREPAIDRQTx).loadTransactionInfo(tcfx,EPREPAIDRQ_LOAD, xmlRequest);

        String resp = EPREPAIDRQTx.process(tcfx, xmlRequest, obj);

        Assert.assertEquals("Prueba3", resp);
    }

    @Test
    public void processDebeRetornarExceptionCuandoLoadTransactionFalla()  throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        String xmlRequest= "";
        Object obj = null;

        Mockito.when(tcfx.getAny()).thenReturn(eprepaid);
        Mockito.when(eprepaid.getTYPE()).thenReturn(LOAD);
        Mockito.doThrow(new ClassNotFoundException("ERROR_TEST")).when(EPREPAIDRQTx).loadTransactionInfo(tcfx,EPREPAIDRQ_LOAD, xmlRequest);

        String resp = EPREPAIDRQTx.process(tcfx, xmlRequest, obj);

        Assert.assertEquals("java.lang.ClassNotFoundException: ERROR_TEST", resp);
    }

}