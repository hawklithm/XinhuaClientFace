package cn.mars.gxkl.UI.dataobject.utils;

import java.util.List;

public interface Rfid {
	public List<String> getRfidByMachineRfid(String machineRfid);
	public List<String> getAllRfid();
}
