package queue;

	public class BackSpaceStringCompare {
		
		static boolean compare(StringBuilder s,
							StringBuilder t)
		{
			int ps, pt, i;
			ps = -1;

			for(i = 0; i < s.length(); i++)
			{
				if (s.charAt(i) == '#' && ps != -1)
					ps -= 1;
				else if (s.charAt(i) != '#')
				{
					s.setCharAt(ps + 1, s.charAt(i));
					ps += 1;
				}
			}

			pt = -1;

			for(i = 0; i < t.length(); i++)
			{
				if (t.charAt(i) == '#' && pt != -1)
					pt -= 1;

				else if (t.charAt(i) != '#')
				{
					t.setCharAt(pt + 1, t.charAt(i));
					
					pt += 1;
				}
			}
			if (pt != ps)
				return false;
			else if (ps == -1 && pt == -1)
				return true;
			else
			{
				for(i = 0; i <= pt; i++)
				{
					if (s.charAt(i) != t.charAt(i))
						return false;
				}
				return true;
			}
		}
		public static void main(String[] args)
		{
			StringBuilder s = new StringBuilder("a#c");
			StringBuilder t = new StringBuilder("b");
			
			if (compare(s, t))
				System.out.print("True");
			else
				System.out.print("False");
		}
	}

	