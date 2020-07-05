import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

class Mobile {

    private boolean touchScreenAvailable;
    private boolean enabled5G;
    private int ram;
    private int cameraPixel;
    private String brandName;
    private String deviceName;
    
    private Mobile() { 
    	//constructor is now private
    }
    
    public boolean isTouchScreenAvailable() {
		return touchScreenAvailable;
	}

	public void setTouchScreenAvailable(boolean touchScreenAvailable) {
		this.touchScreenAvailable = touchScreenAvailable;
	}

	public boolean isEnabled5G() {
		return enabled5G;
	}

	public void setEnabled5G(boolean enabled5g) {
		enabled5G = enabled5g;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getCameraPixel() {
		return cameraPixel;
	}

	public void setCameraPixel(int cameraPixel) {
		this.cameraPixel = cameraPixel;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	public String printDetails() {
		return "Mobile [touchScreenAvailable=" + touchScreenAvailable + ", enabled5G=" + enabled5G + ", ram=" + ram
				+ ", cameraPixel=" + cameraPixel + ", brandName=" + brandName + ", deviceName=" + deviceName + "]";
	}

	static class MobileBuilder {
        
    	private boolean touchScreenAvailable;
        private boolean enabled5G;
        private int ram;
        private int cameraPixel;
        private String brandName;
        private String deviceName;

        public MobileBuilder(String ram, String cameraPixel) {
            this.ram = Integer.parseInt(ram);
            this.cameraPixel = Integer.parseInt(cameraPixel);
        } 

        public MobileBuilder setTouchScreenAvailable(boolean touchScreenAvailable) {
        	this.touchScreenAvailable = touchScreenAvailable;
        	return this;
        }
        
        public MobileBuilder setEnabled5G(boolean enabled5G) {
        	this.enabled5G = enabled5G;
        	return this;
        }
        
        public MobileBuilder setRam(int ram) {
        	this.ram = ram;
        	return this;
        }
        
        public MobileBuilder setCameraPixel(int cameraPixel) {
        	this.cameraPixel = cameraPixel;
        	return this;
        }
        		
        public Mobile build() {
        	Mobile mb = new Mobile();
        	mb.touchScreenAvailable = touchScreenAvailable;
        	mb.enabled5G = enabled5G;
        	mb.ram = ram;
        	mb.cameraPixel = cameraPixel;
        	mb.brandName = brandName;
        	mb.deviceName = deviceName;
        	return mb;
        }
        
    }  

} 

public class Solution2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        int n = Integer.parseInt(sub);
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            Mobile mobile = new Mobile.MobileBuilder(temp[0], temp[1])
                    .setTouchScreenAvailable(Boolean.parseBoolean(temp[2]))
                    .setEnabled5G(Boolean.parseBoolean(temp[3]))
                    .setRam(Integer.parseInt(temp[4]))
                    .setCameraPixel(Integer.parseInt(temp[5])).build();
            mobile.printDetails();
        }
    }
}