class Solution {
    //DC 21.1.23
    public List<String> restoreIpAddresses(String s) {
	List<String> result = new ArrayList<>();
	if (s == null || s.length() == 0 || s.length() > 12) return result;

	restoreIpAddressesHelper(s, 0, 0, new StringBuilder(), result);
	return result;
}

private void restoreIpAddressesHelper(String s, int index, int count, 
									  StringBuilder sb, List<String> result) {
	// Base cases
	if (index == s.length() && count == 3) {
		result.add(sb.toString());
		return;
	}
	if (count > 3) return;

	for (int i = index; i < s.length(); i++) {
		String part = s.substring(index, i + 1);

		if (part.length() == 0 || part.length() > 1 && part.charAt(0) == '0' || 
		   Integer.valueOf(part) > 255) break; // No point of exploring more, so break from the loop

		int len = sb.length();
		// Choose
		sb.append(part);

		// Explore
		if (i + 1 == s.length())
			restoreIpAddressesHelper(s, i + 1, count, sb, result);
		else {
			sb.append("."); // Add . in each time, except the last part
			restoreIpAddressesHelper(s, i + 1, count + 1, sb, result);
		}		
		// Unchoose
		sb.setLength(len);
	}        
}
}