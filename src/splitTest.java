

	import java.util.ArrayList;
	import java.util.List;

	public class splitTest {

		public static void main(String[] args) {
			String s="abc; def; ghi; jkl; mno; pqr; stu; vwx;yz";
			System.out.println(split(s));
			
		}

		private static List<String> split( final String str )
		{
		    final List<String> res = new ArrayList<String>( 10 );
		    int pos, prev = 0;
		    String m_separator = "; ";
			while ( ( pos = str.indexOf( m_separator, prev ) ) != -1 )
		    {
		        res.add( str.substring( prev, pos ) );
		        prev = pos + m_separator.length(); // start from next char after separator
		    }
		    res.add( str.substring( prev ) );
		    return res;
		}
	}

