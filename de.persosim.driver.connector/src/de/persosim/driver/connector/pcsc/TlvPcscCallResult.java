package de.persosim.driver.connector.pcsc;

import de.persosim.driver.connector.NativeDriverInterface;
import de.persosim.simulator.utils.HexString;

/**
 * This {@link PcscCallResult} contains PCSC-style tlv encoded data. 
 * @author mboonk
 *
 */
public class TlvPcscCallResult implements PcscCallResult {

	private String resultData;

	public TlvPcscCallResult(int responseCode, byte[] tag, byte[] dataValue) {
		resultData = responseCode + NativeDriverInterface.MESSAGE_DIVIDER + HexString.encode(PcscDataHelper.buildTlv(tag, dataValue));
	}

	@Override
	public String getEncoded() {
		return resultData;
	}

}
