package benchmarkTest;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread) // 벤치마크 사용 argument를 스레드별로 초기화
@BenchmarkMode(Mode.AverageTime) // 평균시간으로 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 밀리세컨드 단위로 실행
@Fork(value = 2, jvmArgs = {"-Xms4g", "-Xmx4g"}) //jvm 두개의 독립적인 프로세스, 4g 힙공간 할당
public class ParallelStreamBenchMark {
	private static final long N = 10_000L;

	@Benchmark
	public long sequentialSum() {
		return LongStream.rangeClosed(1, N)
			.parallel()
			.reduce(0L, Long::sum);
	}

	@TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음 가비지 컬렉터 동작 시도
	public void tearDown() {
		System.gc();
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
			.include(ParallelStreamBenchMark.class.getSimpleName())
			.warmupIterations(2) // 사전 테스트 횟수
			.measurementIterations(2) // 실제 측정 횟수
			.forks(1)
			.build();
		new Runner(opt).run();
	}
}
