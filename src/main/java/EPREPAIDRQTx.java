public class EPREPAIDRQTx {

    private static final String BALANCE = "BALANCE";
    private static final String DETAIL = "DETAIL";
    private static final String LOAD = "LOAD";
    private static final String EPREPAIDRQ_BALANCE = "EPREPAIDRQ_BALANCE";
    private static final String EPREPAIDRQ_DETAIL = "EPREPAIDRQ_DETAIL";
    private static final String EPREPAIDRQ_LOAD = "EPREPAIDRQ_LOAD";


    public String process(Object xml, String xmlRequest, Object obj) {
        TCFX tcfx = (TCFX) xml;
        EPREPAIDRQ eprepaid = (EPREPAIDRQ) tcfx.getAny();
        try {
            if(eprepaid.getTYPE().equals(BALANCE) ) {
                return loadTransactionInfo(tcfx,EPREPAIDRQ_BALANCE,xmlRequest);
            }else if(eprepaid.getTYPE().equals(DETAIL)) {
                return loadTransactionInfo(tcfx,EPREPAIDRQ_DETAIL,xmlRequest);
            }else if (eprepaid.getTYPE().equals(LOAD)){
                return loadTransactionInfo(tcfx,EPREPAIDRQ_LOAD,xmlRequest);
            }
            return null;
        } catch (Exception e) {
            //LogFwtx.getInstance().getLogger().error(“Error”,e);
            return e.toString();
        }
    }

    public String loadTransactionInfo(TCFX tcfx, String transactionId, String xmlRequest)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException{
        /*ChannelGroup channel  = ConfigurationManager.getInstance(tcfx.getHEADERRQ().getBusinessAPPID()).getChannel();
        TransactionGroup trnInfo = channel.getTransactionsGroup().get(transactionId);
        tcfx.getHEADERRQ().setTransactionInfo(trnInfo);
        tcfx.getHEADERRQ().setChannel(Integer.parseInt(trnInfo.getChannelID()));
        tcfx.getHEADERRQ().setModality(trnInfo.getModality());
        Object objClass = Class.forName(tcfx.getHEADERRQ().getTransactionInfo().getClassI()).newInstance();
        TransactionService tx = (TransactionService) objClass;
        return tx.process(tcfx,xmlRequest,null);*/
        return "prueba";
    }


}
