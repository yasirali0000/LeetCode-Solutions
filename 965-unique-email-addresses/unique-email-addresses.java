class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for(String email : emails) {
            String[] arr = email.split("@");

            String local = arr[0];
            String domain = arr[1];

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < local.length(); i++) {
                char ch = local.charAt(i);

                if(ch == '+') break;

                if(ch != '.') {
                    sb.append(ch);
                }
            }

            sb.append("@").append(domain);

            set.add(sb.toString());
        }

        return set.size();
    }
}