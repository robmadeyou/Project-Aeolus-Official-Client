package com.aeolus.sound;
import com.aeolus.net.Buffer;

final class SoundSample
{

	public static void method166()
	{
		anIntArray116 = new int[32768];
		for(int i = 0; i < 32768; i++)
			if(Math.random() > 0.5D)
				anIntArray116[i] = 1;
			else
				anIntArray116[i] = -1;

		anIntArray117 = new int[32768];
		for(int j = 0; j < 32768; j++)
			anIntArray117[j] = (int)(Math.sin((double)j / 5215.1903000000002D) * 16384D);

		anIntArray115 = new int[0x35d54];
	}

	public int[] method167(int i, int j)
	{
		for(int k = 0; k < i; k++)
			anIntArray115[k] = 0;

		if(j < 10)
			return anIntArray115;
		double d = (double)i / ((double)j + 0.0D);
		aClass29_98.resetValues();
		aClass29_99.resetValues();
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		if(aClass29_100 != null)
		{
			aClass29_100.resetValues();
			aClass29_101.resetValues();
			l = (int)(((double)(aClass29_100.end - aClass29_100.start) * 32.768000000000001D) / d);
			i1 = (int)(((double)aClass29_100.start * 32.768000000000001D) / d);
		}
		int k1 = 0;
		int l1 = 0;
		int i2 = 0;
		if(aClass29_102 != null)
		{
			aClass29_102.resetValues();
			aClass29_103.resetValues();
			k1 = (int)(((double)(aClass29_102.end - aClass29_102.start) * 32.768000000000001D) / d);
			l1 = (int)(((double)aClass29_102.start * 32.768000000000001D) / d);
		}
		for(int j2 = 0; j2 < 5; j2++)
			if(anIntArray106[j2] != 0)
			{
				anIntArray118[j2] = 0;
				anIntArray119[j2] = (int)((double)anIntArray108[j2] * d);
				anIntArray120[j2] = (anIntArray106[j2] << 14) / 100;
				anIntArray121[j2] = (int)(((double)(aClass29_98.end - aClass29_98.start) * 32.768000000000001D * Math.pow(1.0057929410678534D, anIntArray107[j2])) / d);
				anIntArray122[j2] = (int)(((double)aClass29_98.start * 32.768000000000001D) / d);
			}

		for(int k2 = 0; k2 < i; k2++)
		{
			int l2 = aClass29_98.step(i);
			int j4 = aClass29_99.step(i);
			if(aClass29_100 != null)
			{
				int j5 = aClass29_100.step(i);
				int j6 = aClass29_101.step(i);
				l2 += method168(j6, j1, aClass29_100.form) >> 1;
				j1 += (j5 * l >> 16) + i1;
			}
			if(aClass29_102 != null)
			{
				int k5 = aClass29_102.step(i);
				int k6 = aClass29_103.step(i);
				j4 = j4 * ((method168(k6, i2, aClass29_102.form) >> 1) + 32768) >> 15;
				i2 += (k5 * k1 >> 16) + l1;
			}
			for(int l5 = 0; l5 < 5; l5++)
				if(anIntArray106[l5] != 0)
				{
					int l6 = k2 + anIntArray119[l5];
					if(l6 < i)
					{
						anIntArray115[l6] += method168(j4 * anIntArray120[l5] >> 15, anIntArray118[l5], aClass29_98.form);
						anIntArray118[l5] += (l2 * anIntArray121[l5] >> 16) + anIntArray122[l5];
					}
				}

		}

		if(aClass29_104 != null)
		{
			aClass29_104.resetValues();
			aClass29_105.resetValues();
			int i3 = 0;
			boolean flag1 = true;
			for(int i7 = 0; i7 < i; i7++)
			{
				int k7 = aClass29_104.step(i);
				int i8 = aClass29_105.step(i);
				int k4;
				if(flag1)
					k4 = aClass29_104.start + ((aClass29_104.end - aClass29_104.start) * k7 >> 8);
				else
					k4 = aClass29_104.start + ((aClass29_104.end - aClass29_104.start) * i8 >> 8);
				if((i3 += 256) >= k4)
				{
					i3 = 0;
					flag1 = !flag1;
				}
				if(flag1)
					anIntArray115[i7] = 0;
			}

		}
		if(anInt109 > 0 && anInt110 > 0)
		{
			int j3 = (int)((double)anInt109 * d);
			for(int l4 = j3; l4 < i; l4++)
				anIntArray115[l4] += (anIntArray115[l4 - j3] * anInt110) / 100;

		}
		if(aClass39_111.pairs[0] > 0 || aClass39_111.pairs[1] > 0)
		{
			aClass29_112.resetValues();
			int k3 = aClass29_112.step(i + 1);
			int i5 = aClass39_111.compute(0, (float)k3 / 65536F);
			int i6 = aClass39_111.compute(1, (float)k3 / 65536F);
			if(i >= i5 + i6)
			{
				int j7 = 0;
				int l7 = i6;
				if(l7 > i - i5)
					l7 = i - i5;
				for(; j7 < l7; j7++)
				{
					int j8 = (int)((long)anIntArray115[j7 + i5] * (long)SoundFilter.forwardMultiplier >> 16);
					for(int k8 = 0; k8 < i5; k8++)
						j8 += (int)((long)anIntArray115[(j7 + i5) - 1 - k8] * (long)SoundFilter.coefficients[0][k8] >> 16);

					for(int j9 = 0; j9 < j7; j9++)
						j8 -= (int)((long)anIntArray115[j7 - 1 - j9] * (long)SoundFilter.coefficients[1][j9] >> 16);

					anIntArray115[j7] = j8;
					k3 = aClass29_112.step(i + 1);
				}

				char c = '\200';
				l7 = c;
				do
				{
					if(l7 > i - i5)
						l7 = i - i5;
					for(; j7 < l7; j7++)
					{
						int l8 = (int)((long)anIntArray115[j7 + i5] * (long)SoundFilter.forwardMultiplier >> 16);
						for(int k9 = 0; k9 < i5; k9++)
							l8 += (int)((long)anIntArray115[(j7 + i5) - 1 - k9] * (long)SoundFilter.coefficients[0][k9] >> 16);

						for(int i10 = 0; i10 < i6; i10++)
							l8 -= (int)((long)anIntArray115[j7 - 1 - i10] * (long)SoundFilter.coefficients[1][i10] >> 16);

						anIntArray115[j7] = l8;
						k3 = aClass29_112.step(i + 1);
					}

					if(j7 >= i - i5)
						break;
					i5 = aClass39_111.compute(0, (float)k3 / 65536F);
					i6 = aClass39_111.compute(1, (float)k3 / 65536F);
					l7 += c;
				} while(true);
				for(; j7 < i; j7++)
				{
					int i9 = 0;
					for(int l9 = (j7 + i5) - i; l9 < i5; l9++)
						i9 += (int)((long)anIntArray115[(j7 + i5) - 1 - l9] * (long)SoundFilter.coefficients[0][l9] >> 16);

					for(int j10 = 0; j10 < i6; j10++)
						i9 -= (int)((long)anIntArray115[j7 - 1 - j10] * (long)SoundFilter.coefficients[1][j10] >> 16);

					anIntArray115[j7] = i9;
				}

			}
		}
		for(int i4 = 0; i4 < i; i4++)
		{
			if(anIntArray115[i4] < -32768)
				anIntArray115[i4] = -32768;
			if(anIntArray115[i4] > 32767)
				anIntArray115[i4] = 32767;
		}

		return anIntArray115;
	}

	private int method168(int i, int k, int l)
	{
		if(l == 1)
			if((k & 0x7fff) < 16384)
				return i;
			else
				return -i;
		if(l == 2)
			return anIntArray117[k & 0x7fff] * i >> 14;
		if(l == 3)
			return ((k & 0x7fff) * i >> 14) - i;
		if(l == 4)
			return anIntArray116[k / 2607 & 0x7fff] * i;
		else
			return 0;
	}

	public void method169(Buffer stream)
	{
		aClass29_98 = new SoundEnvelope();
		aClass29_98.decode(stream);
		aClass29_99 = new SoundEnvelope();
		aClass29_99.decode(stream);
		int i = stream.readUnsignedByte();
		if(i != 0)
		{
			stream.currentOffset--;
			aClass29_100 = new SoundEnvelope();
			aClass29_100.decode(stream);
			aClass29_101 = new SoundEnvelope();
			aClass29_101.decode(stream);
		}
		i = stream.readUnsignedByte();
		if(i != 0)
		{
			stream.currentOffset--;
			aClass29_102 = new SoundEnvelope();
			aClass29_102.decode(stream);
			aClass29_103 = new SoundEnvelope();
			aClass29_103.decode(stream);
		}
		i = stream.readUnsignedByte();
		if(i != 0)
		{
			stream.currentOffset--;
			aClass29_104 = new SoundEnvelope();
			aClass29_104.decode(stream);
			aClass29_105 = new SoundEnvelope();
			aClass29_105.decode(stream);
		}
		for(int j = 0; j < 10; j++)
		{
			int k = stream.method422();
			if(k == 0)
				break;
			anIntArray106[j] = k;
			anIntArray107[j] = stream.method421();
			anIntArray108[j] = stream.method422();
		}

		anInt109 = stream.method422();
		anInt110 = stream.method422();
		anInt113 = stream.getUnsignedLEShort();
		anInt114 = stream.getUnsignedLEShort();
		aClass39_111 = new SoundFilter();
		aClass29_112 = new SoundEnvelope();
		aClass39_111.decode(stream, aClass29_112);
	}

	public SoundSample()
	{
		anIntArray106 = new int[5];
		anIntArray107 = new int[5];
		anIntArray108 = new int[5];
		anInt110 = 100;
		anInt113 = 500;
	}

	private SoundEnvelope aClass29_98;
	private SoundEnvelope aClass29_99;
	private SoundEnvelope aClass29_100;
	private SoundEnvelope aClass29_101;
	private SoundEnvelope aClass29_102;
	private SoundEnvelope aClass29_103;
	private SoundEnvelope aClass29_104;
	private SoundEnvelope aClass29_105;
	private final int[] anIntArray106;
	private final int[] anIntArray107;
	private final int[] anIntArray108;
	private int anInt109;
	private int anInt110;
	private SoundFilter aClass39_111;
	private SoundEnvelope aClass29_112;
	int anInt113;
	int anInt114;
	private static int[] anIntArray115;
	private static int[] anIntArray116;
	private static int[] anIntArray117;
	private static final int[] anIntArray118 = new int[5];
	private static final int[] anIntArray119 = new int[5];
	private static final int[] anIntArray120 = new int[5];
	private static final int[] anIntArray121 = new int[5];
	private static final int[] anIntArray122 = new int[5];

}
