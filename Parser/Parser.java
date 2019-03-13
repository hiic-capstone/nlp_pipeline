public class Parser {
    String mFileName = "";

    public static void main(String[] args) {
        mFileName = args[1];
        readFileByLine();
    }

    public void readFileByLine( ) {
        String theLine = null;

        try {
            FileReader fileReader = new FileReader( mFileName );
            BufferedReader bufferedReader = new BufferedReader( fileReader );

            while(( line = bufferedReader.readLine()) != null ) {
                if( line.equals("") ) continue;

                Condition theCondition = getConditionFromLine( line );
                if( theCondition == null ) continue;
                
                String theSQLQuery = theCondition.getSQLAddQuery();
                if( theSQLQuery.equals( "" ) ) continue;

                // TODO: run this sql query
            }

            bufferedReader.close();
        }
        catch( Exception e ) {
            System.out.println("File Read error: " + mFileName);
        }
    }

    public Condition getConditionFromLine( String line ) {
        String[] theSplitLine = ParsingUtils.splitByMinSpace( line, 5 );

        String theConditionType = theSplitLine[0];
        Condition theResCondition = null;
        if( theConditionType.equals("NamedEntity") ) {
            theResCondition = new ConceptsCondition(theSplitLine);
        } else if( theConditionType.equals("Sentence") ) {

        } else if( theConditionType.equals("Token") ) {

        } else {
            System.out.println( "Unknown condition type: " + theSplitLine[0] );
        }

        return theResCondition;
    }
}