public class student {

    public static void linearSearch(Integer t) {

        ListInteger lon = new ListInteger();

        lon.add(4);
        lon.add(5);
        lon.add(6);

        for(Integer i=0;ilon.size();i++) {

            if(lon[i] == t) {

                System.debug('Found');

                return;
            }
        }

        System.debug('Not Found');
    }
}