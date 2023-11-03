package stock.chart.stock.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import stock.chart.domain.Stock;
import stock.chart.domain.StockPrice;
import stock.chart.member.dto.MemberInfoDto;
import stock.chart.stock.dto.StockDataDto;


public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("select new stock.chart.stock.dto.StockDataDto (s.code, s.name) from Stock s where s.code = :code")
    Optional<StockDataDto> findStockNameById(@Param("code") String code);


    @Query("select s from Stock s where s.code = :code")
    Optional<Stock> findStockById(@Param("code") String code);


}
